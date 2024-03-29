package com.turkcell.rentacar.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {

    private String firstName;
    private String lastName;
    private String nationalityId;
    private String eMail;
    private String phoneNumber;

}
