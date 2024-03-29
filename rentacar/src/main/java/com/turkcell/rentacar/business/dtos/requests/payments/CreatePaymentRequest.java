package com.turkcell.rentacar.business.dtos.requests.payments;

import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePaymentRequest {
    private Rental rental;
}
