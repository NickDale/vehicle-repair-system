package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.ProvidedService;
import java.util.List;
import java.util.Optional;

public interface ProvidedServiceService {
    List<ProvidedService> findAll();
    Optional<ProvidedService> findById(Integer id);
    ProvidedService save(ProvidedService entity);
    void deleteById(Integer id);
}
