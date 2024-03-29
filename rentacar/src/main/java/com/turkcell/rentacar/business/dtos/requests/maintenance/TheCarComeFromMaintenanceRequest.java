package com.turkcell.rentacar.business.dtos.requests.maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheCarComeFromMaintenanceRequest {
    private int id;
    private LocalDateTime dateReturned;
    private int carId;
}
