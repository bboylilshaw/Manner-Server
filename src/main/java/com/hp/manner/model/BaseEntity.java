package com.hp.manner.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.ObjectIdJsonSerializer;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@ToString
public abstract class BaseEntity {

    @Id
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    protected ObjectId id;

}
