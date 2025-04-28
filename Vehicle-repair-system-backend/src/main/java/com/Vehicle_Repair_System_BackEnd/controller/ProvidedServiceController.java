package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.ProvidedService;
import com.Vehicle_Repair_System_BackEnd.service.ProvidedServiceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/provided-services")
@RequiredArgsConstructor
public class ProvidedServiceController {

    private final ProvidedServiceService service;

    @GetMapping
    public ResponseEntity<List<ProvidedService>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvidedService> getById(@PathVariable  @Positive int id) {
        Optional<ProvidedService> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProvidedService> create(@Valid @RequestBody ProvidedService entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvidedService> update(@PathVariable  @Positive int id,
                                                  @Valid @RequestBody ProvidedService updated) {
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
