package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.CustomerMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {
    private CorporateCustomerRepository corporateCustomerRepository;

    public void isCorporateCustomerExistById(int id){
        Optional<CorporateCustomer> corporateCustomer = this.corporateCustomerRepository.findById(id);
        if(corporateCustomer.isEmpty()){
            throw new BusinessException(CustomerMessages.CORPARATE_CUSTOMER_NOT_EXIST);
        }
    }
}
