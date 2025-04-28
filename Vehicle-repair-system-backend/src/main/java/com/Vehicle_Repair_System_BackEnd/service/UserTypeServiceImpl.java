package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.UserType;
import com.Vehicle_Repair_System_BackEnd.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository repository;

    @Override
    public List<UserType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserType> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public UserType save(UserType entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
