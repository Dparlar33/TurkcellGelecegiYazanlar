package com.turkcell.rentacar.business.dtos.responses.maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedMaintenanceResponse {
    private int id;
    private LocalDateTime deletedDate;
}
