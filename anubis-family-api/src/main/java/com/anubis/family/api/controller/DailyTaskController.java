package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.anubis.core.entity.family.DailyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/daily")
public class DailyTaskController {

    @Autowired
    private TaskService<DailyTask> dailyTaskService;

    @GetMapping("/count")
    public Integer getDailyTaskCount() {
        return getDailyTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<DailyTask> getDailyTasks() {
        return getDailyTaskService().getAllTasks();
    }

    @PostMapping
    public DailyTask createDailyTask(@RequestBody DailyTask task) {
        return getDailyTaskService().createTask(task);
    }

    public TaskService<DailyTask> getDailyTaskService() {
        return dailyTaskService;
    }

}
