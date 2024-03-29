package com.turkcell.rentacar.business.dtos.responses.cars;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedCarResponse {
    private int id;
    private LocalDateTime deletedDate;
}
