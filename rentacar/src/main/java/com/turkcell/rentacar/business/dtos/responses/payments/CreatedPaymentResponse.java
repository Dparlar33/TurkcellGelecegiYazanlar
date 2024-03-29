package com.turkcell.rentacar.business.dtos.responses.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedPaymentResponse {
    private int id;
    private int rentalId;
}
