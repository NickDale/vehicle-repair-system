package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.ProvidedService;
import com.Vehicle_Repair_System_BackEnd.repository.ProvidedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvidedServiceServiceImpl implements ProvidedServiceService {

    private final ProvidedServiceRepository repository;

    @Override
    public List<ProvidedService> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProvidedService> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ProvidedService save(ProvidedService entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
