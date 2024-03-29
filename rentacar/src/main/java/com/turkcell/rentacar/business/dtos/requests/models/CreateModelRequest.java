package com.turkcell.rentacar.business.dtos.requests.models;

import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateModelRequest {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    private int brandId;
    private int fuelId;
    private int transmissionId;
}
