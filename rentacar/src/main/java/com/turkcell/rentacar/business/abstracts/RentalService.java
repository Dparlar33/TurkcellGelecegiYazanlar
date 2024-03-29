package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.*;

import java.util.List;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);
    List<GetAllRentalResponse> getAll();
    GetByIdRentalResponse getById(int id);
    UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest);
    DeletedRentalResponse delete(int id);
}
