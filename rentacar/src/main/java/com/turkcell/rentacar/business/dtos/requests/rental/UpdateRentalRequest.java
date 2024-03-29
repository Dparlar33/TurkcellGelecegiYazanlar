package com.turkcell.rentacar.business.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalRequest {
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int customerId;
    private int carId;
}
