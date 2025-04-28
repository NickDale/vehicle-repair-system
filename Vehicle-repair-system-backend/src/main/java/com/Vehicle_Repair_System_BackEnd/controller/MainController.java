package com.Vehicle_Repair_System_BackEnd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@AuthenticationPrincipal Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName());
    }
}
