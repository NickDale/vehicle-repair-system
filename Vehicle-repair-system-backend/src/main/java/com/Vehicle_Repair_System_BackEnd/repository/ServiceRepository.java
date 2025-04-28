package com.Vehicle_Repair_System_BackEnd.repository;

import com.Vehicle_Repair_System_BackEnd.model.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<CarService, Integer> {
}