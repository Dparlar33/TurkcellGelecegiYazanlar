package com.turkcell.rentacar.business.dtos.responses.transmissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedTransmissionResponse {
    private int id;
    private boolean isDeleted;
    private LocalDateTime deletedDate;
}
