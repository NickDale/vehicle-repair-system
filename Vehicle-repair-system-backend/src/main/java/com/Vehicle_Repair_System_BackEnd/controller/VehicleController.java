package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.Vehicle;
import com.Vehicle_Repair_System_BackEnd.service.VehicleService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable @Positive int id) {
        Optional<Vehicle> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable  @Positive int id, @RequestBody Vehicle updated) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id);
        return ResponseEntity.ok(service.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable  @Positive int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
