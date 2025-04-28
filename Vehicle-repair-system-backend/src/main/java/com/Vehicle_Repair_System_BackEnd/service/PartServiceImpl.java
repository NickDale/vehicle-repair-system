package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.Part;
import com.Vehicle_Repair_System_BackEnd.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository repository;

    @Override
    public List<Part> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Part> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Part save(Part entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
