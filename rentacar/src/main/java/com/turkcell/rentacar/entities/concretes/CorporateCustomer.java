package com.turkcell.rentacar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer{

    @Column(name = "corporate_id", insertable = false, updatable = false)
    private Integer corporateId;

    @Column(name="corporate_name")
    private String name;

    @Column(name = "tax_id_number")
    private String taxIdNumber;
}

