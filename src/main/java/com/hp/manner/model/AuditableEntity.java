package com.hp.manner.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.util.Date;

@Getter
@Setter
public abstract class AuditableEntity {

    @CreatedDate
    private Date createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Date updatedDate;

    @LastModifiedBy
    private String updatedBy;

    @Version
    private Long version;

}
