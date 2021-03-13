package com.anubis.family.api.service;

import com.tcramer.anubis.core.dao.TaskRepo;
import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.FamilyMember;
import com.tcramer.anubis.core.entity.family.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl<T extends Task> implements TaskService<T> {

    @Autowired
    private TaskRepo<T> taskRepo;

    @Override
    public T createTask(T task) {
        return taskRepo.save(task);
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
    public List<T> getWeeklyTasks() {
        return null;
//        return getTaskRepo().getTaskByDiscriminator(TaskType.Discriminator.WEEKLY);
    }

    @Override
    public List<T> getTasksForFamilyMember(FamilyMember familyMember) {
        return null;
    }

    public TaskRepo getTaskRepo() {
        return taskRepo;
    }

    public void setTaskRepo(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
}
