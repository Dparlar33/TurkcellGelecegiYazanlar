package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.DeleteCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.*;
import com.turkcell.rentacar.business.rules.CorporateCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CorporateCustomerManager implements CorporateCustomerService {
    private CorporateCustomerRepository corporateCustomerRepository;
    private ModelMapperService modelMapperService;
    private CorporateCustomerBusinessRules corporateCustomerBusinessRules;
    @Override
    public CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(createCorporateCustomerRequest,CorporateCustomer.class);
        corporateCustomer.setCreatedDate(LocalDateTime.now());
        CorporateCustomer saveCustomer = this.corporateCustomerRepository.save(corporateCustomer);
        return this.modelMapperService.forResponse().map(saveCustomer, CreatedCorporateCustomerResponse.class);
    }
    @Override
    public List<GotCorporateCustomerResponse> getAll() {
        return this.corporateCustomerRepository.findAll().stream().map(corporateCustomer ->
                this.modelMapperService.forResponse().
                        map(corporateCustomer, GotCorporateCustomerResponse.class)).collect(Collectors.toList());
    }
    @Override
    public DeletedCorporateCustomerResponse delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
        this.corporateCustomerBusinessRules.isCorporateCustomerExistById(deleteCorporateCustomerRequest.getCustomerId());
        Optional<CorporateCustomer> corporateCustomer = this.corporateCustomerRepository.
                findById(deleteCorporateCustomerRequest.getCustomerId());
        corporateCustomer.get().setDeletedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().map(corporateCustomer, DeletedCorporateCustomerResponse.class);
    }
    public UpdatedCorporateCustomerResponse update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        this.corporateCustomerBusinessRules.isCorporateCustomerExistById(updateCorporateCustomerRequest.getId());
        CorporateCustomer corporateCustomer =
                this.modelMapperService.forRequest().map(updateCorporateCustomerRequest,CorporateCustomer.class);
        corporateCustomer.setUpdatedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().
                map(this.corporateCustomerRepository.save(corporateCustomer), UpdatedCorporateCustomerResponse.class);
    }

}
