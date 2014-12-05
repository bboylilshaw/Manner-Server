package com.hp.manner.domain;

import com.hp.manner.common.ItemType;
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
import javax.validation.constraints.NotNull;
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
    private String title;

    @NotEmpty
    private String content;

    @NotNull
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @NotNull
    @ManyToOne
    @CreatedBy
    private User createdBy;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    private Date createdDate;

    @NotNull
    @ManyToOne
    @LastModifiedBy
    private User lastModifiedBy;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    private Date lastModifiedDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @NotNull
    private Status status;

    @NotNull
    @Min(0) @Max(100)
    private int percentage;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dueDate;

    @NotNull
    private Priority priority;

    private String remarks;

}
