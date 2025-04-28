package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    private String email;
    private String hashedPassword;
    private String salt;

    private String createBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}