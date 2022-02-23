package com.anubis.family.api.controller;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.service.task.DailyTaskServiceImpl;
import com.anubis.family.api.model.User;
import com.anubis.family.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMINISTRATOR')")
@RestController
@RequestMapping("/task/daily")
public class DailyTaskController {

    @Autowired
    private DailyTaskServiceImpl dailyTaskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @GetMapping("/count")
    public Integer getDailyTaskCount() {
        return getDailyTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<DailyTask> getDailyTasks() {
        return getDailyTaskService().getAllTasks();
    }

    @GetMapping("/user/{userId}")
    public List<DailyTask> getDailyTasksForFamilyMember(@PathVariable Integer userId) {
        User user = userRepository.findById(userId.longValue()).orElseThrow(() -> new UsernameNotFoundException("Could not find userId."));
        FamilyMember familyMemberId = familyMemberRepo.findFamilyMemberByEmail(user.getEmail());
        return getDailyTaskService().getTasksForFamilyMember(familyMemberId);
    }

    @GetMapping("/{taskId}")
    public DailyTask getDailyTask(@PathVariable Integer taskId) {
        return getDailyTaskService().findTaskById(taskId);
    }

    @PostMapping
    public DailyTask createDailyTask(@RequestBody DailyTask task) {
        return getDailyTaskService().createTask(task);
    }

    public DailyTaskServiceImpl getDailyTaskService() {
        return dailyTaskService;
    }

}
