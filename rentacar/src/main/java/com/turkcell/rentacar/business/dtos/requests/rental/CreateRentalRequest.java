package com.turkcell.rentacar.business.dtos.requests.rental;

import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int customerId;
    private int carId;
}
