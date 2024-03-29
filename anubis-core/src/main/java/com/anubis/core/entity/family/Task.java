package com.anubis.core.entity.family;

import com.anubis.core.constants.TaskType;
import com.anubis.core.entity.interfaces.Created;
import com.anubis.core.entity.interfaces.Discriminated;
import com.anubis.core.entity.interfaces.Named;
import com.anubis.core.entity.interfaces.Reminded;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(TaskType.Discriminator.BASE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Task extends BaseTask implements Created, Discriminated, Named, Reminded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Reminder> reminders;

    public Task(String name) {
        super(name);
    }

    public Task() {
        super();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getDiscriminator() {
        return TaskType.Discriminator.BASE;
    }

    @Override
    public List<Reminder> getReminders() {
        return this.reminders;
    }

    @Override
    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void addReminder(Reminder reminder) {
        this.reminders.add(reminder);
    }


}
