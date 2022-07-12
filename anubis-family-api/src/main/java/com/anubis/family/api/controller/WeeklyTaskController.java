package com.anubis.family.api.controller;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.WeeklyTask;
import com.anubis.core.service.family.FamilyMemberService;
import com.anubis.core.service.task.TaskService;
import com.anubis.core.service.task.WeeklyTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task/weekly")
public class WeeklyTaskController {

    private FamilyMemberService familyMemberService;
    @Autowired
    WeeklyTaskServiceImpl weeklyTaskTaskService;

    @GetMapping("/count")
    public Integer getWeeklyTaskCount() {
        return getWeeklyTaskTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<WeeklyTask> getWeeklyTasks() {
        return getWeeklyTaskTaskService().getAllTasks();
    }

    @GetMapping("/user/{userId}")
    public List<WeeklyTask> getDailyTasksForFamilyMember(@PathVariable long userId) {
        FamilyMember familyMember = getFamilyMemberService().getFamilyMemberByUserId(userId);
        return getWeeklyTaskTaskService().getWeeklyTasksForFamilyMember(familyMember);
    }

    @GetMapping("/family/{familyId}")
    public List<WeeklyTask> getDailyTasksForFamily(@PathVariable long familyId) {
        return getWeeklyTaskTaskService().getWeeklyTasksForFamily(familyId);
    }

    @GetMapping("/{taskId}")
    public WeeklyTask getDailyTask(@PathVariable Integer taskId) {
        return getWeeklyTaskTaskService().findById(taskId);
    }

    @PostMapping
    public WeeklyTask createWeeklyTask(@RequestBody WeeklyTask task) {
        return getWeeklyTaskTaskService().createTask(task);
    }

    public WeeklyTaskServiceImpl getWeeklyTaskTaskService() {
        return weeklyTaskTaskService;
    }

    public FamilyMemberService getFamilyMemberService() {
        return familyMemberService;
    }

    @Autowired
    public void setFamilyMemberService(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }
}
