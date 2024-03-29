package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionController {
    private TransmissionService transmissionService; //IoC inversion of control
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@RequestBody CreateTransmissionRequest createTransmissionRequest){
        return this.transmissionService.add(createTransmissionRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionResponse> getAll(){
        return this.transmissionService.getAll();
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdTransmissionResponse getById(@PathVariable int id){
        return this.transmissionService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedTransmissionResponse update(@RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return this.transmissionService.update(updateTransmissionRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedTransmissionResponse delete(@PathVariable int id){
        return this.transmissionService.delete(id);
    }
}
