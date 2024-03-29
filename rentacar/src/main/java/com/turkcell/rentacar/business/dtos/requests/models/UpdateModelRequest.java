package com.turkcell.rentacar.business.dtos.requests.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateModelRequest {
    private int id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    private int brand_id;
    @NotNull
    private int fuel_id;
    @NotNull
    private int transmission_id;
}
