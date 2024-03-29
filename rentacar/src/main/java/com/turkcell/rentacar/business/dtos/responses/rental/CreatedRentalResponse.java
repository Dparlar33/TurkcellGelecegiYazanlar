package com.turkcell.rentacar.business.dtos.responses.rental;

import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedRentalResponse {
    private int id;
    private double totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int customerId;
    private int carId;
}
