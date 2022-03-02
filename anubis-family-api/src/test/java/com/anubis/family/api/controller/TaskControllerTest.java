package com.anubis.family.api.controller;

import com.anubis.core.constants.TaskType;
import com.anubis.core.entity.family.Task;
import com.anubis.core.service.task.TaskService;
import com.anubis.family.api.model.IsCompleteDTO;
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
import static org.mockito.Mockito.verify;
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

    @Test
    public void createTask() {
        Task task = new Task(DAILY_TASK_1_NAME);
        when(taskService.createTask(task)).thenReturn(task);

        Task resp = taskController.createTask(task);
        Assertions.assertEquals(DAILY_TASK_1_NAME, resp.getName());
        Assertions.assertEquals(TaskType.Discriminator.BASE, resp.getDiscriminator());
    }

    @Test
    public void getTaskTypes() {
        TaskType[] taskTypes = TaskType.values();
        TaskType[] retrievedValues = taskController.getTaskTypes();

        Assertions.assertEquals(taskTypes.length, retrievedValues.length);
        Assertions.assertEquals(1337, retrievedValues[0].getId());
    }

    @Test
    public void getTaskTypeNames() {
        List<String> taskTypeNames = TaskType.Name.getNames();
        List<String> retrievedValues = taskController.getTaskTypeNames();

        Assertions.assertEquals(taskTypeNames.size(), retrievedValues.size());
        Assertions.assertEquals("BASE", retrievedValues.get(0));
    }

    @Test
    public void markTaskComplete() {
        //given
        IsCompleteDTO isComplete = new IsCompleteDTO();
        isComplete.setIsComplete(true);
        isComplete.setTaskId(1);
        //when
        taskController.markTaskComplete(isComplete);
        //then
        verify(taskService).markTaskCompleted(1);
    }

    @Test
    public void markTaskInComplete() {
        //given
        IsCompleteDTO isComplete = new IsCompleteDTO();
        isComplete.setIsComplete(false);
        isComplete.setTaskId(1);
        //when
        taskController.markTaskComplete(isComplete);
        //then
        verify(taskService).markTaskIncomplete(1);
    }
}
