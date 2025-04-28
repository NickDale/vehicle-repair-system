package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "repair_orders", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepairOrder extends AuditorEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "appointment_request_id")
    private AppointmentRequest appointmentRequest;

    private String note;
    private String repairDescription;

    @OneToMany(mappedBy = "repairOrder")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "repairOrder")
    private List<AppliedPart> appliedParts;

    @OneToMany(mappedBy = "repairOrder")
    private List<ProvidedService> providedServices;
}