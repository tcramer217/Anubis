package com.anubis.core.dao;

import com.anubis.core.AnubisTestConstants;
import com.anubis.core.entity.family.Family;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Reminder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static com.anubis.core.AnubisTestConstants.FAMILY_NAME;
import static com.anubis.core.AnubisTestConstants.REMINDER_NAME;

@DisplayName("Verify the functionality of the ReminderRepo.")
@DataJpaTest
public class ReminderRepoTestDB {

    @Autowired
    private ReminderRepo reminderRepo;

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Test
    @Rollback(false)
    void create() {
        Family cramerFamily = new Family("Cramer Family");
        cramerFamily = getFamilyRepo().save(cramerFamily);
        FamilyMember timCramer = new FamilyMember(
                AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME,
                AnubisTestConstants.FAMILY_MEMBER_LAST_NAME,
                AnubisTestConstants.FAMILY_MEMBER_EMAIL_ADDRESS,
                cramerFamily);
        timCramer = getFamilyMemberRepo().save(timCramer);
        Reminder reminder = new Reminder(REMINDER_NAME, timCramer);
        reminder = getReminderRepo().save(reminder);

        Assertions.assertEquals(REMINDER_NAME, reminder.getName());

        Assertions.assertEquals(FAMILY_NAME, reminder.getReminderFor().getLastName());
    }

    @Test
    void read() {
        List<Reminder> reminder = getReminderRepo().findRemindersByReminderFor_Family_FamilyName(FAMILY_NAME);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }

    public ReminderRepo getReminderRepo() {
        return reminderRepo;
    }

    public void setReminderRepo(ReminderRepo reminderRepo) {
        this.reminderRepo = reminderRepo;
    }

    public FamilyRepo getFamilyRepo() {
        return familyRepo;
    }

    public void setFamilyRepo(FamilyRepo familyRepo) {
        this.familyRepo = familyRepo;
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }
}
