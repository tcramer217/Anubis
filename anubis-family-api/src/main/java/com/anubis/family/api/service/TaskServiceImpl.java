package com.anubis.family.api.service;

import com.tcramer.anubis.core.dao.TaskRepo;
import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.FamilyMember;
import com.tcramer.anubis.core.entity.family.Task;
import com.tcramer.anubis.core.entity.family.WeeklyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl<T extends Task> implements TaskService<T> {

    private final TaskRepo<T> taskRepo;

    public TaskServiceImpl(TaskRepo<T> taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public T createTask(T task) {
        return getTaskRepo().save(task);
    }

    @Override
    public List<T> getAllTasks() {
        return getTaskRepo().findAll();
    }

    @Override
    public List<DailyTask> getDailyTasks() {
        return getTaskRepo().findDailyTasks();
    }

    @Override
    public List<WeeklyTask> getWeeklyTasks() {
        return getTaskRepo().findWeeklyTasks();
    }

    @Override
    public List<T> getTasksForFamilyMember(FamilyMember familyMember) {
        return null;
    }

    @Autowired
    public TaskRepo<T> getTaskRepo() {
        return taskRepo;
    }
}
