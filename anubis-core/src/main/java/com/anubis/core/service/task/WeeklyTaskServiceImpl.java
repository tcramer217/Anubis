package com.anubis.core.service.task;

import com.anubis.core.dao.TaskRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.WeeklyTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyTaskServiceImpl extends TaskServiceImpl<WeeklyTask> {

    private final TaskRepo<WeeklyTask> weeklyTaskRepo;

    public WeeklyTaskServiceImpl(TaskRepo<WeeklyTask> weeklyTaskRepo) {
        super(weeklyTaskRepo);
        this.weeklyTaskRepo = weeklyTaskRepo;
    }

    public List<WeeklyTask> getWeeklyTasksForFamily(long familyId) {
        return getWeeklyTaskRepo().findWeeklyTasksForFamily(familyId);
    }

    public List<WeeklyTask> getWeeklyTasksForFamilyMember(FamilyMember familyMemberId) {
        return getWeeklyTaskRepo().findWeeklyTasksForFamilyMember(familyMemberId);
    }

    public TaskRepo<WeeklyTask> getWeeklyTaskRepo() {
        return weeklyTaskRepo;
    }
}
