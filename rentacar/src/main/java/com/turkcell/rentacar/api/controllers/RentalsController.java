package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rental")
public class RentalsController {
    private RentalService rentalService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse add(@RequestBody CreateRentalRequest createRentalRequest){
        return this.rentalService.add(createRentalRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllRentalResponse> getAll(){
        return this.rentalService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdRentalResponse getById(@PathVariable int id){return this.rentalService.getById(id);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedRentalResponse update(@RequestBody UpdateRentalRequest updateRentalRequest){
        return this.rentalService.update(updateRentalRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedRentalResponse delete(@PathVariable int id){
        return this.rentalService.delete(id);
    }
}
