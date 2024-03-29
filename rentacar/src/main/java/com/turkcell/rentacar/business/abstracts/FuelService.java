package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.fuels.*;

import java.util.List;

public interface FuelService {
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    public GetByIdFuelResponse getById(int id);
    public List<GetAllFuelResponse> getAll();
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest);
    public DeletedFuelResponse delete(int id);

}
