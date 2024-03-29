package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.MaintenanceMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;
    private CarRepository carRepository;
    public void checkIfCarInMaintenance(int carId) {
        Car car = this.carRepository.findById(carId).orElse(null);
        if ((car.getState() == Car.State.Under_Maintenance)) {
            throw new BusinessException(MaintenanceMessages.CAR_ALREADY_IN_MAINTENANCE);
        }
    }
    public void checkIfCarInRented(int carId){
        Car car = this.carRepository.findById(carId).orElse(null);
        if (car.getState() == Car.State.Rented) {
            throw new BusinessException(MaintenanceMessages.CAR_IS_RENTED);
        }
    }
    public void isMaintenanceExistById(int id){
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);
        if(maintenance.isEmpty()){
            throw new BusinessException(MaintenanceMessages.MAINTENANCE_NOT_EXIST);
        }
    }

}
