package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.AppliedPart;
import java.util.List;
import java.util.Optional;

public interface AppliedPartService {
    List<AppliedPart> findAll();
    Optional<AppliedPart> findById(Integer id);
    AppliedPart save(AppliedPart entity);
    void deleteById(Integer id);
}
