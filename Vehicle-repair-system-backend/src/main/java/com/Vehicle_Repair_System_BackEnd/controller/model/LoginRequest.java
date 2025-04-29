package com.Vehicle_Repair_System_BackEnd.controller.model;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String username,
                           @NotBlank String password) {
}
