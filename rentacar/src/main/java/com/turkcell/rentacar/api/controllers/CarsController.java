package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService; //IoC inversion of control
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest) {
        return this.carService.add(createCarRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarResponse> getAll() {
        return this.carService.getAll();
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdCarResponse getById(@PathVariable int id) {
        return this.carService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCarResponse update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCarResponse delete(@PathVariable int id) {
        return this.carService.delete(id);
    }
}
