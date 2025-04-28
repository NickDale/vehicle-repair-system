package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "provided_services", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvidedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private CarService carService;

    private String description;
    private Integer quantity;
    private Double price;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}