package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.PaymentService;
import com.turkcell.rentacar.business.dtos.responses.payments.GetAllPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/payments")
public class PaymentController {
    private PaymentService paymentService;
 /*   @PostMapping("/payment")
    public CreatedCustomerPaymentInformationResponse makePayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        CreatedCustomerPaymentInformationResponse createdCustomerPaymentInformationResponse = new CreatedCustomerPaymentInformationResponse();
        createdCustomerPaymentInformationResponse.setMakePayment(true);
        return createdCustomerPaymentInformationResponse;
    }*/
    @GetMapping("/getAll")
    public List<GetAllPaymentResponse> getAll(){
        return this.paymentService.getAll();
    }
}
