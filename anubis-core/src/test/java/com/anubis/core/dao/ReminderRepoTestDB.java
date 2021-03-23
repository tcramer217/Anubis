package com.anubis.core.dao;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DisplayName("Verify the functionality of the ReminderRepo.")
@DataJpaTest
public class ReminderRepoTestDB {

    @Autowired
    private ReminderRepo reminderRepo;

    public ReminderRepo getReminderRepo() {
        return reminderRepo;
    }

    public void setReminderRepo(ReminderRepo reminderRepo) {
        this.reminderRepo = reminderRepo;
    }
}
