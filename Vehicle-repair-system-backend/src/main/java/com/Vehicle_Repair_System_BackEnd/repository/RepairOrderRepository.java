package com.Vehicle_Repair_System_BackEnd.repository;

import com.Vehicle_Repair_System_BackEnd.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, Integer> {
}
