package com.hp.manner.domain;

import com.hp.manner.common.Priority;
import com.hp.manner.common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "t_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Item extends AbstractPersistable<Long> {

    @NotEmpty
    private String content;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @CreatedBy
    private User createdBy;

    @CreatedDate
    private Date createdDate;

    @ManyToOne
    @LastModifiedBy
    private User lastModifiedBy;

    @LastModifiedDate
    private Date lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private Status status;

    @Min(0) @Max(100)
    private int percentage;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dueDate;

    private Priority priority;

    private String remarks;

}
