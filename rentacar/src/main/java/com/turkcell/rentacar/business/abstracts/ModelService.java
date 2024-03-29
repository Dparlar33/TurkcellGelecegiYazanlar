package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.*;

import java.util.List;

public interface ModelService {
    public CreatedModelResponse add(CreateModelRequest createModelRequest);
    public GetByIdModelResponse getById(int id);
    public List<GetAllModelResponse> getAll();
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest);
    public DeletedModelResponse delete(int id);
}
