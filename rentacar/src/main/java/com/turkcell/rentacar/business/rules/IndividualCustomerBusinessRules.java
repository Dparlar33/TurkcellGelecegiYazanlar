package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.CustomerMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;

    public void isIndividualCustomerExistById(int id){
       Optional<IndividualCustomer>  individualCustomer = this.individualCustomerRepository.findById(id);
       if (individualCustomer.isEmpty()){
           throw new BusinessException(CustomerMessages.INDIVIDUAL_CUSTOMER_NOT_EXIST);
       }
    }
}
