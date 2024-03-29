package com.turkcell.rentacar.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorporateCustomerRequest {
    private String name;
    private String taxIdNumber;
    private String eMail;
    private String phoneNumber;

}
