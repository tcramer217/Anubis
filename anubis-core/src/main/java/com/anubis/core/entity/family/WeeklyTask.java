package com.anubis.core.entity.family;

import com.anubis.core.constants.TaskType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value= TaskType.Discriminator.WEEKLY)
public class WeeklyTask extends Task {

    public WeeklyTask(String name) {
        super(name);
    }

    public WeeklyTask() {
    }

    @Override
    public String getDiscriminator() {
        return TaskType.Discriminator.WEEKLY;
    }
}
