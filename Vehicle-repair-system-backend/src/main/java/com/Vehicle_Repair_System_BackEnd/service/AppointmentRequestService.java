package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.AppointmentRequest;
import java.util.List;
import java.util.Optional;

public interface AppointmentRequestService {
    List<AppointmentRequest> findAll();
    Optional<AppointmentRequest> findById(Integer id);
    AppointmentRequest save(AppointmentRequest entity);
    void deleteById(Integer id);
}
