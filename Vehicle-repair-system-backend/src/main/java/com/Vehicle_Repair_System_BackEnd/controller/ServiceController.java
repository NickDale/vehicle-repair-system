package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.ServiceEntity;
import com.Vehicle_Repair_System_BackEnd.service.ServiceService;
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
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getById(@PathVariable @Positive int id) {
        Optional<ServiceEntity> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServiceEntity> create(@Valid @RequestBody ServiceEntity entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> update(@PathVariable @Positive int id,
                                                @Valid @RequestBody ServiceEntity updated) {
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
