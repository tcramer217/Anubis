package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.anubis.core.entity.family.WeeklyTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.anubis.family.test.AnubisTestConstants.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeeklyTaskControllerTest {

    @Mock
    TaskService<WeeklyTask> weeklyTaskService;

    @InjectMocks
    WeeklyTaskController weeklyTaskController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void createWeeklyTask() {
        WeeklyTask weeklyTask = new WeeklyTask(WEEKLY_TASK_1_NAME);
        when(weeklyTaskService.createTask(weeklyTask))
                .thenReturn(weeklyTask);

        WeeklyTask resp = weeklyTaskController.createWeeklyTask(weeklyTask);
        Assertions.assertEquals(WEEKLY_TASK_1_NAME, resp.getName());
    }

//    @Test
//    public void getWeeklyTaskCount() {
//        WeeklyTask wt1 = new WeeklyTask(WEEKLY_TASK_1_NAME);
//        WeeklyTask wt2 = new WeeklyTask(WEEKLY_TASK_2_NAME);
//
//        when(weeklyTaskService.getTasksByDiscriminator()).thenReturn(Arrays.asList(wt1, wt2));
//
//        Integer result = weeklyTaskController.getWeeklyTaskCount();
//        Assertions.assertEquals(2, result);
//    }
//
//    @Test
//    public void getWeeklyTasks() {
//        WeeklyTask dt1 = new WeeklyTask(WEEKLY_TASK_1_NAME);
//        WeeklyTask dt2 = new WeeklyTask(WEEKLY_TASK_2_NAME);
//
//        when(weeklyTaskService.getTasksByDiscriminator()).thenReturn(Arrays.asList(dt1, dt2));
//
//        List<WeeklyTask> result = weeklyTaskController.getWeeklyTasks();
//        Assertions.assertEquals(2, result.size());
//        Assertions.assertEquals(WEEKLY_TASK_1_NAME, result.get(INDEX_1).getName());
//        Assertions.assertEquals(WEEKLY_TASK_2_NAME, result.get(INDEX_2).getName());
//    }
}
