package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;
import com.turkcell.rentacar.business.dtos.responses.payments.GetAllPaymentResponse;

import java.util.List;

public interface PaymentService {
    CreatedPaymentResponse add(CreatePaymentRequest createPaymentRequest);
    List<GetAllPaymentResponse> getAll();
}
