package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.anubis.core.entity.family.WeeklyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/weekly")
public class WeeklyTaskController {

    @Autowired
    TaskService<WeeklyTask> weeklyTaskTaskService;

    @GetMapping("/count")
    public Integer getWeeklyTaskCount() {
        return getWeeklyTaskTaskService().getAllTasks().size();
    }

    @GetMapping
    public List<WeeklyTask> getWeeklyTasks() {
        return getWeeklyTaskTaskService().getAllTasks();
    }

    @PostMapping
    public WeeklyTask createWeeklyTask(@RequestBody WeeklyTask task) {
        return getWeeklyTaskTaskService().createTask(task);
    }

    public TaskService<WeeklyTask> getWeeklyTaskTaskService() {
        return weeklyTaskTaskService;
    }
}
