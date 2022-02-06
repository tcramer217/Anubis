package com.anubis.core.service.task;

import com.anubis.core.dao.TaskRepo;
import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTaskServiceImpl implements TaskService<DailyTask> {

    private final TaskRepo<DailyTask> dailyTaskRepo;

    public DailyTaskServiceImpl(TaskRepo<DailyTask> dailyTaskRepo) {
        this.dailyTaskRepo = dailyTaskRepo;
    }

    @Override
    public DailyTask createTask(DailyTask task) {
        return getDailyTaskRepo().save(task);
    }

    @Override
    public List<DailyTask> getAllTasks() {
        return getDailyTaskRepo().findDailyTasks();
    }

    @Override
    public List<DailyTask> getTasksForFamilyMember(FamilyMember familyMember) {
        return null;
    }

    public TaskRepo<DailyTask> getDailyTaskRepo() {
        return dailyTaskRepo;
    }
}
