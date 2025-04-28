package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.Part;
import java.util.List;
import java.util.Optional;

public interface PartService {
    List<Part> findAll();
    Optional<Part> findById(Integer id);
    Part save(Part entity);
    void deleteById(Integer id);
}
