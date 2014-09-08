package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.DateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Set;

@Document
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends BaseEntity {

    private String subject;

    @NotEmpty
    private String content;

    @DBRef
    private User owner;

    @CreatedBy
    @DBRef
    private User createdBy;

    @CreatedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date createdDate;

    @LastModifiedBy
    @DBRef
    private User lastModifiedBy;

    @LastModifiedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date lastModifiedDate;

    private Status status;

    @Min(0) @Max(100)
    private int percentage;

    @JsonSerialize(using = DateSerializer.class)
    private Date dueDate;

    @JsonSerialize(using = DateSerializer.class)
    private Date deferDate;

    private Priority priority;

    private String category;

    private String remarks;

    @Min(0) @Max(5)
    private int level;

    private Set<String> tag;

    private String group;

    @JsonIgnore
    @Version
    private Long version;

}
