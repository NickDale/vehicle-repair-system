package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.RepairOrder;
import java.util.List;
import java.util.Optional;

public interface RepairOrderService {
    List<RepairOrder> findAll();
    Optional<RepairOrder> findById(Integer id);
    RepairOrder save(RepairOrder entity);
    void deleteById(Integer id);
}
