package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.WeeklyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class DailyTaskController {

    @Autowired
    TaskService<DailyTask> dailyTaskService;

    @Autowired
    TaskService<WeeklyTask> weeklyTaskTaskService;

    @PostMapping("/daily")
    public DailyTask createDailyTask(@RequestBody DailyTask task) {
        DailyTask dailyTask = dailyTaskService.createTask(task);
        return dailyTask;
    }

    @PostMapping("/weekly")
    public WeeklyTask createWeeklyTask(@RequestBody WeeklyTask task) {
        WeeklyTask dailyTask = weeklyTaskTaskService.createTask(task);
        return dailyTask;
    }

    @GetMapping
    public List<DailyTask> getTasks() {
        return dailyTaskService.getAllTasks();
    }

    @GetMapping("/daily")
    public List<DailyTask> getDailyTasks() {
        return dailyTaskService.getDailyTasks();
    }

}
