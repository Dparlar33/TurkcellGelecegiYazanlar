package com.turkcell.rentacar.business.dtos.requests.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorporateCustomerRequest {
    @NotNull
    private int id;
    private String name;
    private String taxIdNumber;
    private String eMail;
    private String phoneNumber;
}
