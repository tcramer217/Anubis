package com.tcramer.anubis.core.entity.family;

import com.tcramer.anubis.core.entity.interfaces.Created;
import com.tcramer.anubis.core.entity.interfaces.Discriminated;
import com.tcramer.anubis.core.entity.interfaces.Named;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTask implements Created, Discriminated, Named {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean inProgress;
    private boolean isComplete;

    @ManyToOne
    private FamilyMember assignedTo;

    @ManyToOne
    private FamilyMember createdBy;

    private LocalDateTime createdAt;

    public BaseTask(String name, FamilyMember assignedTo) {
        this.name = name;
        this.assignedTo = assignedTo;
    }

    public BaseTask(String name) {
        this.name = name;
    }

    public BaseTask() {
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public FamilyMember getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(FamilyMember assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String getDiscriminator() {
        return null;
    }

    public long getId() {
        return id;
    }

    @Override
    public FamilyMember getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public void setCreatedBy(FamilyMember familyMember) {
        this.createdBy = familyMember;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
