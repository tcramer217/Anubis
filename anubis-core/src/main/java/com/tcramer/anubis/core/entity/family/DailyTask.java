package com.tcramer.anubis.core.entity.family;

import com.tcramer.anubis.core.constants.TaskType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value= TaskType.Discriminator.DAILY)
public class DailyTask extends Task {

    @Override
    public String getDiscriminator() {
        return TaskType.Discriminator.DAILY;
    }
}
