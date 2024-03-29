package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.TheCarComeFromMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/maintenances")
@RequiredArgsConstructor
public class MaintenancesController {
    private final MaintenanceService maintenanceService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMaintenanceResponse add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        return this.maintenanceService.add(createMaintenanceRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllMaintenanceResponse> getAll(){
        return this.maintenanceService.getAll();
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdMaintenanceResponse getById(@PathVariable int id){
        return this.maintenanceService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedMaintenanceResponse update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest){
        return this.maintenanceService.update(updateMaintenanceRequest);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedMaintenanceResponse delete(@PathVariable int id){
        return this.maintenanceService.delete(id);
    }
    @PostMapping("/theCarComeFromMaintenance") //Api Bu sekilde olmali mi?
    @ResponseStatus(HttpStatus.OK)
    public TheCarComeFromMaintenanceResponse theCarComeFromMaintenance(@RequestBody TheCarComeFromMaintenanceRequest theCarComeFromMaintenanceRequest){
        return this.maintenanceService.carComeFromMaintenance(theCarComeFromMaintenanceRequest);
    }
}
