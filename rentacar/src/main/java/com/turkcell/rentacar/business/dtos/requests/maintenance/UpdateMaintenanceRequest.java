package com.turkcell.rentacar.business.dtos.requests.maintenance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateMaintenanceRequest {
    private int id;
    private int carId;
    private LocalDateTime dateSent;
    private LocalDateTime dataReturned;
}
