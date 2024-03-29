package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.TheCarComeFromMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.*;

import java.util.List;

public interface MaintenanceService {
    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);
    List<GetAllMaintenanceResponse> getAll();
    UpdatedMaintenanceResponse update(UpdateMaintenanceRequest updateMaintenanceRequest);
    GetByIdMaintenanceResponse getById(int id);
    DeletedMaintenanceResponse delete(int id);
    TheCarComeFromMaintenanceResponse carComeFromMaintenance(TheCarComeFromMaintenanceRequest theCarComeFromMaintenanceRequest);
}
