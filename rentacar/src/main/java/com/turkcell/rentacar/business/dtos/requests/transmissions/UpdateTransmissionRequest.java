package com.turkcell.rentacar.business.dtos.requests.transmissions;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTransmissionRequest {
    private int id;
    @NotNull
    private String name;
}
