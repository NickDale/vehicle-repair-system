package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String phone;
    private String city;
    private String postcode;
    private String street;
    private String streetNumber;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;
}