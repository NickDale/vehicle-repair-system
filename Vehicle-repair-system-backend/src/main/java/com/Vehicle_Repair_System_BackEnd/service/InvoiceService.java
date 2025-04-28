package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.model.Invoice;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();
    Optional<Invoice> findById(Integer id);
    Invoice save(Invoice entity);
    void deleteById(Integer id);
}
