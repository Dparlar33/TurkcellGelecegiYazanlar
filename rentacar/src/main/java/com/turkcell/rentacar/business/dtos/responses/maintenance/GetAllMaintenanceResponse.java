package com.turkcell.rentacar.business.dtos.responses.maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMaintenanceResponse {
    private int id;
    private LocalDateTime dateSent;
    private String carName;
}
