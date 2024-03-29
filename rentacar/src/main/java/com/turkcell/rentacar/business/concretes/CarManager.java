package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.*;

import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;
    private ModelBusinessRules modelBusinessRules;
    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        this.modelBusinessRules.isModelExistById(createCarRequest.getModelId());
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);

        car.setState(this.carBusinessRules.setCarStateFromIntegerToEnum(createCarRequest.getState()));
        car.setCreatedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(this.carRepository.save(car),CreatedCarResponse.class);
    }
    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElse(null);
        this.carBusinessRules.isCarExistById(id);
        return this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
    }
    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();
        return cars.stream().map(car -> this.modelMapperService.forResponse().
                map(car, GetAllCarResponse.class)).collect(Collectors.toList());
    }
    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carBusinessRules.isCarExistById(updateCarRequest.getId());

        car.setUpdatedDate(LocalDateTime.now());
        this.carRepository.save(car);
        return this.modelMapperService.forResponse().map(car,UpdatedCarResponse.class);
    }
    @Override
    public DeletedCarResponse delete(int id) {
        Car car = this.carRepository.findById(id).orElse(null);
        this.carBusinessRules.isCarExistById(id);

        car.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(car,DeletedCarResponse.class);
    }
}
