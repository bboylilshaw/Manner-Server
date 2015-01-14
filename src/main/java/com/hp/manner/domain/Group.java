package com.hp.manner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "t_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Group extends AbstractPersistable<Long> implements Serializable {

    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;

    @ManyToOne
    private User owner;

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", owner=" + owner +
                '}';
    }

}
