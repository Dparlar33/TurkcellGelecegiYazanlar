package com.turkcell.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdIndividualCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalityId;
    private String eMail;
    private String phoneNumber;
}
