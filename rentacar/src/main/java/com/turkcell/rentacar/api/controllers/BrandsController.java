package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {
    private BrandService brandService; //IoC inversion of control
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return this.brandService.add(createBrandRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return this.brandService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedBrandResponse delete(@PathVariable int id) {
        return this.brandService.delete(id);
    }
}
