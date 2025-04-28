package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "applied_parts", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppliedPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    private String description;
    private Integer quantity;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}