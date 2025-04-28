package com.Vehicle_Repair_System_BackEnd.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditorEntity extends AbstractEntity {

    @CreatedBy
    private String createBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedBy
    private String modifiedBy;
    @LastModifiedDate
    private Date modifiedDate;
}
