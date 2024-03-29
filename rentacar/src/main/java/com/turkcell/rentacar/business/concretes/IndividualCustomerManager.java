package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.*;
import com.turkcell.rentacar.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = this.modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        individualCustomer.setCreatedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().
                map(this.individualCustomerRepository.save(individualCustomer), CreatedIndividualCustomerResponse.class);
    }
    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        return  this.individualCustomerRepository.findAll().stream().map(individualCustomer ->
                this.modelMapperService.forResponse().map(individualCustomer, GetAllIndividualCustomerResponse.class)).collect(Collectors.toList());
    }
    @Override
    public GetByIdIndividualCustomerResponse getById(int id) {
        this.individualCustomerBusinessRules.isIndividualCustomerExistById(id);
        return this.modelMapperService.forResponse().
                map(this.individualCustomerRepository.findById(id),GetByIdIndividualCustomerResponse.class);
    }
    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        this.individualCustomerBusinessRules.isIndividualCustomerExistById(updateIndividualCustomerRequest.getId());
        IndividualCustomer individualCustomer =
                this.modelMapperService.forRequest().map(updateIndividualCustomerRequest,IndividualCustomer.class);
        individualCustomer.setUpdatedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().
                map(this.individualCustomerRepository.save(individualCustomer), UpdatedIndividualCustomerResponse.class);
    }
    @Override
    public DeletedIndividualCustomerResponse delete(int id) {
        this.individualCustomerBusinessRules.isIndividualCustomerExistById(id);
        Optional<IndividualCustomer>  individualCustomer = this.individualCustomerRepository.findById(id);
        individualCustomer.get().setDeletedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().map(individualCustomer,DeletedIndividualCustomerResponse.class);
    }
}
