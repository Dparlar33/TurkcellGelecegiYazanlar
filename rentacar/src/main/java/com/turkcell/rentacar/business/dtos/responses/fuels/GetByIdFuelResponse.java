package com.turkcell.rentacar.business.dtos.responses.fuels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdFuelResponse {
    private int id;
    private String name;
}
