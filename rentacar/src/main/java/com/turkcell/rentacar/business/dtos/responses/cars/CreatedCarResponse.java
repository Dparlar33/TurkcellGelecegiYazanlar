package com.turkcell.rentacar.business.dtos.responses.cars;

import com.turkcell.rentacar.entities.concretes.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCarResponse {
    private int id;
    private int findexScore;
    private int modelYear;
    private String plate;
    private String modelName;
    private Car.State state;
    private int dailyPrice;
    private String brandName;
    private String fuelName;
    private String transmissionName;
    private LocalDateTime createdDate;
}
