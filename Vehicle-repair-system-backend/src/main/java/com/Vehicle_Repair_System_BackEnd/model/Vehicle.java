package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vehicles", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle extends AuditorEntity {

    private String name;

    @NotBlank
    @Column(nullable = false)
    private String plateNumber;
    @NotBlank
    @Column(nullable = false)
    private String brand;
    @NotBlank
    @Column(nullable = false)
    private String model;
    private Integer year;
    private String vinNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "vehicle")
    private List<AppointmentRequest> appointmentRequests;

    @OneToMany(mappedBy = "vehicle")
    private List<RepairOrder> repairOrders;
}