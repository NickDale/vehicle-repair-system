package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.AppointmentRequest;
import com.Vehicle_Repair_System_BackEnd.repository.AppointmentRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentRequestServiceImpl implements AppointmentRequestService {

    private final AppointmentRequestRepository repository;

    @Override
    public List<AppointmentRequest> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AppointmentRequest> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public AppointmentRequest save(AppointmentRequest entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
