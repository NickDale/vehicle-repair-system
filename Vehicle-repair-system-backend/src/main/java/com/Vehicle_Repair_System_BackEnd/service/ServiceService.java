package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.ServiceEntity;
import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<ServiceEntity> findAll();
    Optional<ServiceEntity> findById(Integer id);
    ServiceEntity save(ServiceEntity entity);
    void deleteById(Integer id);
}
