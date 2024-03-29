package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.*;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    List<GetAllIndividualCustomerResponse> getAll();
    GetByIdIndividualCustomerResponse getById(int id);
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    DeletedIndividualCustomerResponse delete(int id);

}
