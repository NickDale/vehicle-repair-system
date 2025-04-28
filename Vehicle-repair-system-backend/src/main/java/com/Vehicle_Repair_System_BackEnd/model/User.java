package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AuditorEntity {

    private String name;
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    private String email;
    private String hashedPassword;
    private String salt;

}