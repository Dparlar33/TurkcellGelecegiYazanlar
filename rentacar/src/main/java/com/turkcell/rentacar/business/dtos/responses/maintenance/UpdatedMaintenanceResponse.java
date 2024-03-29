package com.turkcell.rentacar.business.dtos.responses.maintenance;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedMaintenanceResponse {
    private int id;
    private LocalDateTime dateReturned;
    private String carName;
}
