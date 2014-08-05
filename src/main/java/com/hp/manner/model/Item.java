package com.hp.manner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.manner.common.DateSerializer;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Set;

@Document
public class Item {

    @Id
    private ObjectId id;

    private String subject;

    @NotEmpty
    private String content;

    @DBRef
    private User owner;

    @CreatedBy
    @DBRef
    private User createdBy;

    @CreatedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date createdDate;

    @LastModifiedBy
    @DBRef
    private User lastModifiedBy;

    @LastModifiedDate
    @JsonSerialize(using = DateSerializer.class)
    private Date lastModifiedDate;

    private Status status;

    @Min(0) @Max(100)
    private int percentage;

    @JsonSerialize(using = DateSerializer.class)
    private Date dueDate;

    @JsonSerialize(using = DateSerializer.class)
    private Date deferDate;

    private Priority priority;

    private String category;

    private String remarks;

    @Min(0) @Max(5)
    private int level;

    private Set<String> tag;

    private String group;

    @JsonIgnore
    @Version
    private Long version;

    public enum Status {
        NEW, WORK_IN_PROGRESS, COMPLETE
    }

    public enum Priority {
        LOW, MEDIUM, HIGH, URGENT
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDeferDate() {
        return deferDate;
    }

    public void setDeferDate(Date deferDate) {
        this.deferDate = deferDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<String> getTag() {
        return tag;
    }

    public void setTag(Set<String> tag) {
        this.tag = tag;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
