package com.hp.manner.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Document
public class User {

    @Id
    private ObjectId id;

    @NotNull(message = "First Name cannot be null!")
    @Size(max = 30, message = "First Name cannot be over 30 characters!")
    private String firstName;

    @NotNull(message = "Last Name cannot be null!")
    @Size(max = 30, message = "Last Name cannot be over 30 characters!")
    private String lastName;

    @NotNull(message = "Common Name cannot be null!")
    @Size(max = 30, message = "Common Name cannot be over 30 characters!")
    private String commonName;

    @NotNull(message = "Email cannot be null!")
    @Email(message = "Email is not valid!")
    @Size(max = 50, message = "Email cannot be over 50 characters!")
    @Indexed(unique = true)
    private String email;

    private String password;
    private Set<String> group;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getGroup() {
        return group;
    }

    public void setGroup(Set<String> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User (Name: " + this.firstName + " " + this.lastName + ", Email: " + this.email + ")";
    }

}
