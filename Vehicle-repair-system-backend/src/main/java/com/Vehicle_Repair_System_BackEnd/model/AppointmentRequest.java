package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointment_requests", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequest extends AuditorEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private String problemDescription;
    private Date recommendedDate;
    private LocalTime startTime;
    private LocalTime endTime;

}