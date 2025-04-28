package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.RepairOrder;
import com.Vehicle_Repair_System_BackEnd.repository.RepairOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepairOrderServiceImpl implements RepairOrderService {

    private final RepairOrderRepository repository;

    @Override
    public List<RepairOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RepairOrder> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public RepairOrder save(RepairOrder entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
