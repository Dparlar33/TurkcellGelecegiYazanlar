package com.turkcell.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCorporateCustomerResponse {
    private int id;
    private String name;
    private String taxIdNumber;
    private String eMail;
    private String phoneNumber;
}
