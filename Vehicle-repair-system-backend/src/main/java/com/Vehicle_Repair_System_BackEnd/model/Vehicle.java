package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicles", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String plateNumber;
    private String brand;
    private String model;
    private Integer year;
    private String vinNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    @OneToMany(mappedBy = "vehicle")
    private List<AppointmentRequest> appointmentRequests;

    @OneToMany(mappedBy = "vehicle")
    private List<RepairOrder> repairOrders;
}