package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applied_parts", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppliedPart extends AuditorEntity {

    @ManyToOne
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    private String description;
    private Integer quantity;

}