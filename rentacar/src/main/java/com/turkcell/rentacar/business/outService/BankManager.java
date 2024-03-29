package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.entities.concretes.Rental;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class BankManager implements BankService {
    private RestTemplate restTemplate;

    @Override
    public CreatedCustomerPaymentInformationResponse makePayment(Rental rental) {
      //  String url = "http://localhost:8081/payment/"; //Burayı düzeltmeyi unutmayın
      //  return this.restTemplate.getForObject(url, CreatedPaymentResponse.class);
        CustomerPaymentInformation customerPaymentInformation = new CustomerPaymentInformation();
        customerPaymentInformation.setBalance(1000);
        customerPaymentInformation.setCardCvv("371");
        customerPaymentInformation.setCardholder("ziraat");
        customerPaymentInformation.setCardExpirationMonth(2);
        customerPaymentInformation.setCardExpirationYear(2030);

        CreatedCustomerPaymentInformationResponse createdCustomerPaymentInformationResponse = new CreatedCustomerPaymentInformationResponse();
        if (isBalanceEnough(customerPaymentInformation.getBalance(),rental.getTotalPrice())){
            createdCustomerPaymentInformationResponse.setMakePayment(true);
        }else {
            createdCustomerPaymentInformationResponse.setMakePayment(false);
        }
        return createdCustomerPaymentInformationResponse;
    }
    public boolean isBalanceEnough(double balance,double totalPrice){
        return balance > totalPrice;
    }
}
