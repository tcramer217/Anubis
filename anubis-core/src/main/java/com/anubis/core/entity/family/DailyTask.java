package com.anubis.core.entity.family;

import com.anubis.core.constants.TaskType;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value= TaskType.Discriminator.DAILY)
public class DailyTask extends Task {

    public DailyTask(String name) {
        super(name);
    }

    public DailyTask() {
    }

    @Override
    public String getDiscriminator() {
        return TaskType.Discriminator.DAILY;
    }
}
