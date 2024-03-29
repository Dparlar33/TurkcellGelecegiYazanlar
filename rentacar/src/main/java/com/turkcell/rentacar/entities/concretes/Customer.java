package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.business.outService.CustomerPaymentInformation;
import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "email")
    private String eMail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

    @OneToOne
    @JoinColumn(name = "corporate_id", referencedColumnName = "id")
    private CorporateCustomer corporateCustomer;

    @OneToOne
    @JoinColumn(name = "individual_id", referencedColumnName = "id")
    private IndividualCustomer individualCustomer;

}
