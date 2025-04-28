package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "invoices", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice extends AuditorEntity {

    @ManyToOne
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;

    private String status;
    private String description;
    private Double totalPrice;
    private String paidBy;
    private Date paidDate;

}