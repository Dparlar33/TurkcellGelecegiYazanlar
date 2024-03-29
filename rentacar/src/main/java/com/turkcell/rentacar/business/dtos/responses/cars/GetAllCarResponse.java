package com.turkcell.rentacar.business.dtos.responses.cars;

import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCarResponse {
    private int id;
    private int findexScore;
    private String modelName;
    private String brandName;
    private int dailyPrice;
    private Car.State state;
    private String plate;
    private String fuelName;
    private String transmissionName;
}
