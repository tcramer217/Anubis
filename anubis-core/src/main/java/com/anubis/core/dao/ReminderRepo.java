package com.anubis.core.dao;

import com.anubis.core.entity.family.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepo extends JpaRepository<Reminder, Long> {
}
