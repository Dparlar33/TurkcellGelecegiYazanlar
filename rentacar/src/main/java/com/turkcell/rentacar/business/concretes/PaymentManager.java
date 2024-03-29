package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.PaymentService;
import com.turkcell.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.payments.CreatedPaymentResponse;
import com.turkcell.rentacar.business.dtos.responses.payments.GetAllPaymentResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.PaymentRepository;
import com.turkcell.rentacar.entities.concretes.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedPaymentResponse add(CreatePaymentRequest createPaymentRequest) {
        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest, Payment.class);
        Payment savedPaymentResponse = this.paymentRepository.save(payment);
        return this.modelMapperService.forResponse().map(savedPaymentResponse,CreatedPaymentResponse.class);
    }

    @Override
    public List<GetAllPaymentResponse> getAll() {
        List<Payment> payments = this.paymentRepository.findAll();
        return payments.stream().map(payment -> this.modelMapperService.forResponse().
                map(payment, GetAllPaymentResponse.class)).collect(Collectors.toList());
    }
}
