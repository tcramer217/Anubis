package com.anubis.family.api.controller;

import com.anubis.core.service.task.TaskService;
import com.anubis.core.entity.family.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.anubis.family.test.AnubisTestConstants.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @Mock
    private TaskService<Task> taskService;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void getTasks() {
        Task dailyTask = new Task(DAILY_TASK_1_NAME);
        Task weeklyTask = new Task(WEEKLY_TASK_1_NAME);
        when(taskService.getAllTasks())
                .thenReturn(Arrays.asList(dailyTask, weeklyTask));

        List<Task> resp = taskController.getTasks();
        Assertions.assertEquals(2, resp.size());
        Assertions.assertEquals(DAILY_TASK_1_NAME, resp.get(INDEX_1).getName());
        Assertions.assertEquals(WEEKLY_TASK_1_NAME, resp.get(INDEX_2).getName());
    }
}
