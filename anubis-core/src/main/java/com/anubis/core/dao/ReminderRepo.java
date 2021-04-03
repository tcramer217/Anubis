package com.anubis.core.dao;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepo extends JpaRepository<Reminder, Long> {
    List<Reminder> findRemindersByReminderFor_Family_FamilyName(String familyName);
}
