package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.AppointmentRequest;
import com.Vehicle_Repair_System_BackEnd.service.AppointmentRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointmentrequests")
@RequiredArgsConstructor
public class AppointmentRequestController {

    private final AppointmentRequestService service;

    @GetMapping
    public ResponseEntity<List<AppointmentRequest>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentRequest> getById(@PathVariable Integer id) {
        Optional<AppointmentRequest> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppointmentRequest> create(@RequestBody AppointmentRequest entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentRequest> update(@PathVariable Integer id, @RequestBody AppointmentRequest updated) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id);
        return ResponseEntity.ok(service.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
