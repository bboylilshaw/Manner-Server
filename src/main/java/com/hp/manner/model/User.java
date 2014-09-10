package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Map;

@Document
@Data
@ToString(exclude = "password")
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

    @JsonIgnore
    private String password;

    private Map<String, String> groups;

    private Role role;

}
