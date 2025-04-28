package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.AppliedPart;
import com.Vehicle_Repair_System_BackEnd.repository.AppliedPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppliedPartServiceImpl implements AppliedPartService {

    private final AppliedPartRepository repository;

    @Override
    public List<AppliedPart> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AppliedPart> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public AppliedPart save(AppliedPart entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
