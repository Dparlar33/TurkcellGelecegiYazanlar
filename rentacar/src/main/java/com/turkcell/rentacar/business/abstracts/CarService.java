package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.*;

import java.util.List;

public interface CarService {
    public CreatedCarResponse add(CreateCarRequest createCarRequest);
    public GetByIdCarResponse getById(int id);
    public List<GetAllCarResponse> getAll();
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest);
    public DeletedCarResponse delete(int id);
}
