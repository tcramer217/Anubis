package com.anubis.core.entity.interfaces;

import com.anubis.core.entity.family.Reminder;

import java.util.List;

/**
 * The Task interface is the base for all tasks.
 */
public interface Reminded {
    List<Reminder> getReminders();
    void setReminders(List<Reminder> reminders);
    void addReminder(Reminder reminder);
}
