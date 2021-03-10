package com.anubis.family.api.service;

import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.FamilyMember;
import com.tcramer.anubis.core.entity.family.Task;

import java.util.List;

public interface TaskService<T extends Task> {

    T createTask(T task);

    List<T> getAllTasks();

    List<DailyTask> getDailyTasks();

    List<T> getWeeklyTasks();

    List<T> getTasksForFamilyMember(FamilyMember familyMember);
}
