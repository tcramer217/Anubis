package com.anubis.core.service.task;

import com.anubis.core.dao.TaskRepo;
import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTaskServiceImpl extends TaskServiceImpl<DailyTask> {

    public DailyTaskServiceImpl(TaskRepo<DailyTask> dailyTaskRepo) {
        super(dailyTaskRepo);
    }

    @Override
    public List<DailyTask> getAllTasks() {
        return getTaskRepo().findDailyTasks();
    }

    public List<DailyTask> getDailyTasksForFamily(long familyId) {
        List<DailyTask> tasks = getTaskRepo().findDailyTasksForFamily(familyId);
        return tasks;
    }

    public List<DailyTask> getDailyTasksForFamilyMember(FamilyMember familyMemberId) {
        List<DailyTask> tasks = getTaskRepo().findDailyTasksForFamilyMember(familyMemberId);
        return tasks;
    }

}
