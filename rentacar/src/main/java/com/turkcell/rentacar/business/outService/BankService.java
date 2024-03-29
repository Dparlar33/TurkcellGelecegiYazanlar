package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.entities.concretes.Rental;


public interface BankService {
    CreatedCustomerPaymentInformationResponse makePayment(Rental rental);

}
