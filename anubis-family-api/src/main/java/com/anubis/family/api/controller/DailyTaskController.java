package com.anubis.family.api.controller;

import com.anubis.core.service.task.DailyTaskServiceImpl;
import com.anubis.core.service.task.TaskService;
import com.anubis.core.entity.family.DailyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/daily")
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
