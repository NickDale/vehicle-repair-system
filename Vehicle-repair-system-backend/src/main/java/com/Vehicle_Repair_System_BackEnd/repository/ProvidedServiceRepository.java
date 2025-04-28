package com.Vehicle_Repair_System_BackEnd.repository;

import com.Vehicle_Repair_System_BackEnd.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Integer> {
}
