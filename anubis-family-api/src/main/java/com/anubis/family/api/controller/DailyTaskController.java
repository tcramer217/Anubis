package com.anubis.family.api.controller;

import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.service.task.DailyTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMINISTRATOR')")
@RestController
@RequestMapping("/task/daily")
public class DailyTaskController {

    @Autowired
    private DailyTaskServiceImpl dailyTaskService;

    @GetMapping("/count")
    public Integer getDailyTaskCount() {
        return getDailyTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<DailyTask> getDailyTasks() {
        return getDailyTaskService().getAllTasks();
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
