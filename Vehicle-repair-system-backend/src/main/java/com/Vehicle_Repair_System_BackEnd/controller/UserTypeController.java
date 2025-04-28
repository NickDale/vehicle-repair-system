package com.Vehicle_Repair_System_BackEnd.controller;

import com.Vehicle_Repair_System_BackEnd.model.UserType;
import com.Vehicle_Repair_System_BackEnd.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/user-types")
@RequiredArgsConstructor
public class UserTypeController {

    private final UserTypeService service;

    @GetMapping
    public ResponseEntity<List<UserType>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
