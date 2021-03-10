package com.tcramer.anubis.core.entity.family;

import com.tcramer.anubis.core.entity.interfaces.Created;
import com.tcramer.anubis.core.entity.interfaces.Named;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reminder implements Created, Named {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime remindAt;

    private String name;

    @ManyToOne
    private DailyTask task;

    @OneToOne
    private FamilyMember reminderFor;

    @OneToOne
    private FamilyMember createBy;

    private LocalDateTime createdAt;

    public Reminder(String name) {
        this.name = name;
    }

    public Reminder() {
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getRemindAt() {
        return remindAt;
    }

    public void setRemindAt(LocalDateTime remindAt) {
        this.remindAt = remindAt;
    }

    public DailyTask getTask() {
        return task;
    }

    public void setTask(DailyTask task) {
        this.task = task;
    }

    public FamilyMember getReminderFor() {
        return reminderFor;
    }

    public void setReminderFor(FamilyMember reminderFor) {
        this.reminderFor = reminderFor;
    }

    @Override
    public FamilyMember getCreatedBy() {
        return this.createBy;
    }

    @Override
    public void setCreatedBy(FamilyMember familyMember) {
        this.createBy = familyMember;
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

    //
//    public FamilyMember getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(FamilyMember createBy) {
//        this.createBy = createBy;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
}
