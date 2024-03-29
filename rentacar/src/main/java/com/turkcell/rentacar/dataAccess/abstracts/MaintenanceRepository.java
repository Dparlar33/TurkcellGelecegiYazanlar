package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
    Optional<Maintenance> getByCarId(int Id);
}
