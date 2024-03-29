package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.*;

import java.util.List;

public interface TransmissionService {
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    public GetByIdTransmissionResponse getById(int id);
    public List<GetAllTransmissionResponse> getAll();
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);
    public DeletedTransmissionResponse delete(int id);
}
