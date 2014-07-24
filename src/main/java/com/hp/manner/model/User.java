package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.DateSerializer;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Map;

@Document
public class User {

    @Id
    //@JsonRawValue
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

    @CreatedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date createdDate;

    @CreatedBy
    @DBRef
    private User createdBy;

    @LastModifiedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date lastModifiedDate;

    @LastModifiedBy
    @DBRef
    private User lastModifiedBy;

    @JsonIgnore
    private String password;

    private Map<String, String> groups;

    private Role role;

    @Version
    private Long version;

    public enum Role {
        SUPERADMIN, ADMIN, USER, GUEST
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, String> groups) {
        this.groups = groups;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User (Name: " + this.firstName + " " + this.lastName + ", Email: " + this.email + ")";
    }

}
