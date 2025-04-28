package com.Vehicle_Repair_System_BackEnd.repository;

import com.Vehicle_Repair_System_BackEnd.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByCustomerId(Integer customerId);
}
