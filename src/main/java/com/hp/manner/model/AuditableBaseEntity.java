package com.hp.manner.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.ObjectIdJsonSerializer;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;

import java.util.Date;

@Getter
@ToString
public abstract class AuditableBaseEntity {

    @Id
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    protected ObjectId id;

    @CreatedDate
    protected Date createdDate;

    @CreatedBy
    protected String createdBy;

    @LastModifiedDate
    protected Date updatedDate;

    @LastModifiedBy
    protected String updatedBy;

    @Version
    protected Long version;

}
