package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelController {
    private ModelService modelService; //IoC inversion of control
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@RequestBody CreateModelRequest createModelRequest){
        return this.modelService.add(createModelRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponse> getAll(){
        return this.modelService.getAll();
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdModelResponse getById(@PathVariable int id){
        return this.modelService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedModelResponse update(@RequestBody UpdateModelRequest updateModelRequest){
        return this.modelService.update(updateModelRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedModelResponse delete(@PathVariable int id){
        return this.modelService.delete(id);
    }
}
