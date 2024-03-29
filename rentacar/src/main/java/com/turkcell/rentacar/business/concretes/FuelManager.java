package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.fuels.*;
import com.turkcell.rentacar.business.rules.FuelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;
    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());

        Fuel createdFuel =  this.fuelRepository.save(fuel);
        return this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
    }

    @Override
    public GetByIdFuelResponse getById(int id) {
        Fuel fuel = this.fuelRepository.findById(id).orElse(null);
        this.fuelBusinessRules.isFuelExistById(fuel.getId());
        return this.modelMapperService.forResponse().map(fuel,GetByIdFuelResponse.class);
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        List<Fuel> fuels = this.fuelRepository.findAll();
        return fuels.stream().map(fuel -> this.modelMapperService.forResponse().
                map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        this.fuelBusinessRules.isFuelExistByUpdateRequest(updateFuelRequest);
        Fuel fuel = this.modelMapperService.forRequest().map(updateFuelRequest,Fuel.class);

        fuel.setUpdatedDate(LocalDateTime.now());
        this.fuelRepository.save(fuel);
        return this.modelMapperService.forResponse().map(fuel,UpdatedFuelResponse.class);
    }

    @Override
    public DeletedFuelResponse delete(int id) {
        this.fuelBusinessRules.isFuelExistById(id);
        Fuel fuel = this.fuelRepository.findById(id).orElse(null);
        //Todo Rule eklenecek.
        fuel.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(fuel,DeletedFuelResponse.class);
    }
}
