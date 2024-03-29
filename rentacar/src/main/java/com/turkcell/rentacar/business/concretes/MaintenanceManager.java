package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.TheCarComeFromMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.*;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {
    private final CarBusinessRules carBusinessRules;
    private final ModelMapperService modelMapperService;
    private final MaintenanceRepository maintenanceRepository;
    private final MaintenanceBusinessRules maintenanceBusinessRules;
    @Override
    public CreatedMaintenanceResponse add( CreateMaintenanceRequest createMaintenanceRequest) {
        this.carBusinessRules.isCarExistById(createMaintenanceRequest.getCarId());
        this.maintenanceBusinessRules.checkIfCarInMaintenance(createMaintenanceRequest.getCarId());
        this.maintenanceBusinessRules.checkIfCarInRented(createMaintenanceRequest.getCarId());

        Maintenance maintenance = this.modelMapperService.forRequest().
                map(createMaintenanceRequest,Maintenance.class);

        this.maintenanceRepository.save(maintenance);
        return this.modelMapperService.forResponse().map(maintenance, CreatedMaintenanceResponse.class);
    }
    @Override
    public List<GetAllMaintenanceResponse>  getAll() {
        List<Maintenance> maintenanceList = this.maintenanceRepository.findAll();

        return maintenanceList.stream().map(maintenance -> this.modelMapperService.forResponse().
                map(maintenance, GetAllMaintenanceResponse.class)).collect(Collectors.toList());
    }
    @Override
    public GetByIdMaintenanceResponse getById(int id) {
        Maintenance maintenance = this.maintenanceRepository.findById(id).orElse(null);
        this.carBusinessRules.isCarExistById(maintenance.getCar().getId());
        return this.modelMapperService.forResponse().map(maintenance, GetByIdMaintenanceResponse.class);
    }
    @Override
    public UpdatedMaintenanceResponse update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        this.maintenanceBusinessRules.isMaintenanceExistById(updateMaintenanceRequest.getId());
        this.maintenanceBusinessRules.checkIfCarInRented(updateMaintenanceRequest.getCarId());

        Maintenance maintenance = this.modelMapperService.forRequest().
                map(updateMaintenanceRequest, Maintenance.class);
        maintenance.setDateReturned(updateMaintenanceRequest.getDataReturned());

        Maintenance updatedMaintenance = this.maintenanceRepository.save(maintenance);
        return this.modelMapperService.forResponse().map(updatedMaintenance, UpdatedMaintenanceResponse.class);
    }
    public TheCarComeFromMaintenanceResponse carComeFromMaintenance(TheCarComeFromMaintenanceRequest theCarComeFromMaintenanceRequest){
        this.carBusinessRules.isCarExistById(theCarComeFromMaintenanceRequest.getCarId());
        this.maintenanceBusinessRules.isMaintenanceExistById(theCarComeFromMaintenanceRequest.getId());

        Optional<Maintenance> maintenance = this.maintenanceRepository.findById(theCarComeFromMaintenanceRequest.getId());
        maintenance.get().setDateReturned(theCarComeFromMaintenanceRequest.getDateReturned());

        return this.modelMapperService.forResponse().map(maintenance, TheCarComeFromMaintenanceResponse.class);
    }
    @Override
    public DeletedMaintenanceResponse delete(int id) {
        this.maintenanceBusinessRules.isMaintenanceExistById(id);
        Maintenance maintenance = this.maintenanceRepository.findById(id).orElse(null);
        maintenance.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(maintenance, DeletedMaintenanceResponse.class);
    }
}
