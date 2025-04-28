package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.CarService;
import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<CarService> findAll();
    Optional<CarService> findById(Integer id);
    CarService save(CarService entity);
    void deleteById(Integer id);
}
