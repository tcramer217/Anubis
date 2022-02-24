package com.anubis.family.api.controller;

import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.service.task.DailyTaskServiceImpl;
import com.anubis.family.api.service.family.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMINISTRATOR')")
@RestController
@RequestMapping("/task/daily")
public class DailyTaskController {

    private FamilyMemberService familyMemberService;
    private DailyTaskServiceImpl dailyTaskService;

    @GetMapping("/count")
    public Integer getDailyTaskCount() {
        return getDailyTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<DailyTask> getDailyTasks() {
        return getDailyTaskService().getAllTasks();
    }

    @GetMapping("/user/{userId}")
    public List<DailyTask> getDailyTasksForFamilyMember(@PathVariable long userId) {
        FamilyMember familyMember = getFamilyMemberService().getFamilyMemberByUserId(userId);
        return getDailyTaskService().getTasksForFamilyMember(familyMember);
    }

    @GetMapping("/{taskId}")
    public DailyTask getDailyTask(@PathVariable Integer taskId) {
        return getDailyTaskService().findTaskById(taskId);
    }

    @PostMapping
    public DailyTask createDailyTask(@RequestBody DailyTask task) {
        return getDailyTaskService().createTask(task);
    }

    @Autowired
    public DailyTaskServiceImpl getDailyTaskService() {
        return dailyTaskService;
    }

    @Autowired
    public FamilyMemberService getFamilyMemberService() {
        return familyMemberService;
    }
}
