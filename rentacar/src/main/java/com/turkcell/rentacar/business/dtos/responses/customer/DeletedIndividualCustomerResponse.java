package com.turkcell.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedIndividualCustomerResponse {
    private int id;
    private LocalDateTime deletedDate;
}
