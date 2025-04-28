package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.AppliedPart;
import com.Vehicle_Repair_System_BackEnd.service.AppliedPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appliedparts")
@RequiredArgsConstructor
public class AppliedPartController {

    private final AppliedPartService service;

    @GetMapping
    public ResponseEntity<List<AppliedPart>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppliedPart> getById(@PathVariable Integer id) {
        Optional<AppliedPart> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppliedPart> create(@RequestBody AppliedPart entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppliedPart> update(@PathVariable Integer id, @RequestBody AppliedPart updated) {
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
