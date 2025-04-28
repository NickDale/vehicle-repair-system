package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.UserType;
import java.util.List;
import java.util.Optional;

public interface UserTypeService {
    List<UserType> findAll();
    Optional<UserType> findById(Integer id);
    UserType save(UserType entity);
    void deleteById(Integer id);
}
