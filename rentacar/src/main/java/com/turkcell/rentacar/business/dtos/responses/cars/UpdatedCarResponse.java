package com.turkcell.rentacar.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCarResponse {
    private int id;
    private String modelName;
    private String brandName;
    private int dailyPrice;
    private String fuelName;
    private String transmissionName;
    private LocalDateTime updatedDate;
}
