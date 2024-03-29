package com.turkcell.rentacar.business.dtos.responses.payments;

import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentResponse {
    private int id;
    private int rentalId;
}
