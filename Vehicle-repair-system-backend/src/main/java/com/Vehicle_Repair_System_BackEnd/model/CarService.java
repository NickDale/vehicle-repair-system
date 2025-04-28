package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "m_services", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double basePrice;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}