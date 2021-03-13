package com.anubis.family.api.service;

import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.FamilyMember;
import com.tcramer.anubis.core.entity.family.Task;
import com.tcramer.anubis.core.entity.family.WeeklyTask;

import java.util.List;

public interface TaskService<T extends Task> {

    T createTask(T task);

    List<T> getAllTasks();

    List<DailyTask> getDailyTasks();

    List<WeeklyTask> getWeeklyTasks();

    List<T> getTasksForFamilyMember(FamilyMember familyMember);
}
