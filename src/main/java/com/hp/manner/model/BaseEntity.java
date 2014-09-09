package com.hp.manner.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.ObjectIdJsonSerializer;
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
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    protected ObjectId id;

    public boolean isNew() {
        return this.id == null;
    }

}
