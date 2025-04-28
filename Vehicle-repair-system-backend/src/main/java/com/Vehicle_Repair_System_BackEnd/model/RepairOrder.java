package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "repair_orders", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepairOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "appointment_request_id")
    private AppointmentRequest appointmentRequest;

    private String note;
    private String repairDescription;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    @OneToMany(mappedBy = "repairOrder")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "repairOrder")
    private List<AppliedPart> appliedParts;

    @OneToMany(mappedBy = "repairOrder")
    private List<ProvidedService> providedServices;
}