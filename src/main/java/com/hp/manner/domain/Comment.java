package com.hp.manner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xiaoyao on 12/9/2014.
 */

@Entity
@Table(name = "t_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Comment extends AbstractPersistable<Long> {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date postDate;

    @ManyToOne
    private User postBy;

    private String body;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
