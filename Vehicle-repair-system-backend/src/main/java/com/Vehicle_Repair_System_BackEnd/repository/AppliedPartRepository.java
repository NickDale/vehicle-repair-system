package com.Vehicle_Repair_System_BackEnd.repository;

import com.Vehicle_Repair_System_BackEnd.model.AppliedPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppliedPartRepository extends JpaRepository<AppliedPart, Integer> {
}
