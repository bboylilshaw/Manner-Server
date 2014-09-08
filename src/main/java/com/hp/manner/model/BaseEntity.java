package com.hp.manner.model;

import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@ToString
public class BaseEntity {

    @Id
    protected ObjectId id;

    public boolean isNew() {
        return this.id == null;
    }

}
