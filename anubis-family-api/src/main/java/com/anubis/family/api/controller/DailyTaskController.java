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

    TaskService<DailyTask> dailyTaskService;
    TaskService<WeeklyTask> weeklyTaskTaskService;

    @GetMapping("/count")
    public Integer getDailyTaskCount() {
        return getDailyTaskService().getDailyTasks().size();
    }

    @PostMapping("/daily")
    public DailyTask createDailyTask(@RequestBody DailyTask task) {
        return getDailyTaskService().createTask(task);
    }

    @PostMapping("/weekly")
    public WeeklyTask createWeeklyTask(@RequestBody WeeklyTask task) {
        return getWeeklyTaskTaskService().createTask(task);
    }

    @GetMapping
    public List<DailyTask> getTasks() {
        return getDailyTaskService().getAllTasks();
    }

    @GetMapping("/daily")
    public List<DailyTask> getDailyTasks() {
        return getDailyTaskService().getDailyTasks();
    }

    @Autowired
    public TaskService<DailyTask> getDailyTaskService() {
        return dailyTaskService;
    }

    @Autowired
    public TaskService<WeeklyTask> getWeeklyTaskTaskService() {
        return weeklyTaskTaskService;
    }
}
