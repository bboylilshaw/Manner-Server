package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Date createdDate;

    @LastModifiedBy
    @DBRef
    private User lastModifiedBy;

    @LastModifiedDate
    private Date lastModifiedDate;

    private Status status;

    @Min(0) @Max(100)
    private int percentage;

    private Date dueDate;

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
