package com.turkcell.rentacar.business.dtos.responses.transmissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdTransmissionResponse {
    private int id;
    private String name;
}
