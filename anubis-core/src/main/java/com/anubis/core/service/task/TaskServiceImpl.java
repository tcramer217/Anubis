package com.anubis.core.service.task;

import com.anubis.core.dao.TaskRepo;
import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;
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
    public T findById(long taskId) {
        return getTaskRepo().findTaskById(taskId);
    }

    @Override
    public void markTaskCompleted(long taskId) {
        T taskForUpdate = findById(taskId);
        taskForUpdate.setComplete(true);
        getTaskRepo().save(taskForUpdate);
    }

    @Override
    public void markTaskIncomplete(long taskId) {
        T taskForUpdate = findById(taskId);
        taskForUpdate.setComplete(false);
        getTaskRepo().save(taskForUpdate);
    }

    @Override
    public List<T> getAllTasks() {
        return getTaskRepo().findAllTasks();
    }

//    @Override
//    public List<DailyTask> getDailyTasksForFamily(long familyId) {
//        List<DailyTask> tasks = getTaskRepo().findDailyTasksForFamily(familyId);
//        return tasks;
//    }
//
//    @Override
//    public List<DailyTask> getDailyTasksForFamilyMember(FamilyMember familyMemberId) {
//        List<DailyTask> tasks = getTaskRepo().findDailyTasksForFamilyMember(familyMemberId);
//        return tasks;
//    }

    @Autowired
    public TaskRepo<T> getTaskRepo() {
        return taskRepo;
    }
}
