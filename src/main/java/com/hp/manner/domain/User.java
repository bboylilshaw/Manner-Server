package com.hp.manner.domain;

import com.hp.manner.common.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(
    name = "t_user",
    indexes = @Index(name = "email_index", columnList = "email", unique = true)
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User extends AbstractPersistable<Long> {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotEmpty
    //@JsonIgnore
    private String password;

    @NotNull
    private Role role;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Collection<Group> groups = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

}

