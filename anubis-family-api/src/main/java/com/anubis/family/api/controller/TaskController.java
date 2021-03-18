package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.anubis.core.entity.family.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService<Task> taskService;

    @GetMapping
    public List<Task> getTasks() {
        return getTaskService().getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return getTaskService().createTask(task);
    }

    public TaskService<Task> getTaskService() {
        return taskService;
    }
}
