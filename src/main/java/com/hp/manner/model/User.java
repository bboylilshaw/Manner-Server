package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.DateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Map;

@Document
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    @NotEmpty
    @Size(max = 30)
    private String firstName;

    @NotEmpty
    @Size(max = 30)
    private String lastName;

    @Size(max = 30)
    private String commonName;

    @NotEmpty
    @Email
    @Size(max = 50)
    @Indexed(unique = true)
    private String email;

    @CreatedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date createdDate;

    @LastModifiedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date lastModifiedDate;

    @JsonIgnore
    private String password;

    private Map<String, String> groups;

    private Role role;

    @JsonIgnore
    @Version
    private Long version;

}
