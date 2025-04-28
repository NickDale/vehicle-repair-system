package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends AuditorEntity {

    @NotBlank
    @Column( nullable = false)
    private String name;
    @NotBlank
    @Column( nullable = false)
    private String email;
    @NotBlank
    @Column( nullable = false)
    private String phone;
    private String city;
    private String postcode;
    private String street;
    private String streetNumber;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;
}