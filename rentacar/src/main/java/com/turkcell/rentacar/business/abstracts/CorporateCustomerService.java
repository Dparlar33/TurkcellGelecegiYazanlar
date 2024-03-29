package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.DeleteCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.DeletedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {
    CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
    List<GotCorporateCustomerResponse> getAll();
    DeletedCorporateCustomerResponse delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);
    UpdatedCorporateCustomerResponse update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);



}
