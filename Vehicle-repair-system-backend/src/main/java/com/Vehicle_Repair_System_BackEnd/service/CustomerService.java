package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Customer save(Customer entity);
    void deleteById(Integer id);
}
