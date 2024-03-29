package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.DeleteCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/corporates")
public class CorporateCustomerController {
    private CorporateCustomerService corporateCustomerService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCorporateCustomerResponse add(@RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        return this.corporateCustomerService.add(createCorporateCustomerRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotCorporateCustomerResponse> getAll(){
        return this.corporateCustomerService.getAll();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCorporateCustomerResponse update(@RequestBody UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        return this.corporateCustomerService.update(updateCorporateCustomerRequest);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCorporateCustomerResponse delete(@RequestBody DeleteCorporateCustomerRequest deleteCorporateCustomerRequest){
        return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
    }
}
