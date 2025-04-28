package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.AppointmentRequest;
import com.Vehicle_Repair_System_BackEnd.service.AppointmentRequestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/appointment-requests")
@RequiredArgsConstructor
public class AppointmentRequestController {

    private final AppointmentRequestService service;

    @GetMapping
    public ResponseEntity<List<AppointmentRequest>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentRequest> getById(@PathVariable @Positive int id) {
        Optional<AppointmentRequest> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppointmentRequest> create(@Valid @RequestBody AppointmentRequest entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentRequest> update(@PathVariable @Positive int id,
                                                     @Valid @RequestBody AppointmentRequest updated) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id);
        return ResponseEntity.ok(service.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
