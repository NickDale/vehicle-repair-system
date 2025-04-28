package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.ServiceEntity;
import com.Vehicle_Repair_System_BackEnd.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Override
    public List<ServiceEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ServiceEntity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ServiceEntity save(ServiceEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
