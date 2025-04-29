package com.Vehicle_Repair_System_BackEnd.model;

import com.Vehicle_Repair_System_BackEnd.model.enums.UserTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_types", schema = "vrs_gamf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserType extends AbstractEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum name;
}