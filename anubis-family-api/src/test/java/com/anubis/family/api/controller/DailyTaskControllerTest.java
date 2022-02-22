package com.anubis.family.api.controller;

import com.anubis.core.service.task.TaskService;
import com.anubis.core.entity.family.DailyTask;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.anubis.family.test.AnubisTestConstants.DAILY_TASK_1_NAME;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DailyTaskControllerTest {

    @Mock
    TaskService<DailyTask> dailyTaskService;

    @InjectMocks
    DailyTaskController dailyTaskController;

    @BeforeEach
    public void setup() {
    }
//
//    @Ignore
//    @Test
//    public void createDailyTask() {
//        DailyTask dailyTask = new DailyTask(DAILY_TASK_1_NAME);
//        when(dailyTaskService.createTask(dailyTask))
//                .thenReturn(dailyTask);
//
//        DailyTask resp = dailyTaskController.createDailyTask(dailyTask);
//        Assertions.assertEquals(DAILY_TASK_1_NAME, resp.getName());
//    }

//    @Test
//    public void getDailyTaskCount() {
//        DailyTask dt1 = new DailyTask(DAILY_TASK_1_NAME);
//        DailyTask dt2 = new DailyTask(DAILY_TASK_2_NAME);
//
//        when(dailyTaskService.getTasksByDiscriminator()).thenReturn(Arrays.asList(dt1, dt2));
//
//        Integer result = dailyTaskController.getDailyTaskCount();
//        Assertions.assertEquals(2, result);
//    }
//
//    @Test
//    public void getDailyTasks() {
//        DailyTask dt1 = new DailyTask(DAILY_TASK_1_NAME);
//        DailyTask dt2 = new DailyTask(DAILY_TASK_2_NAME);
//
//        when(dailyTaskService.getTasksByDiscriminator()).thenReturn(Arrays.asList(dt1, dt2));
//
//        List<DailyTask> result = dailyTaskController.getDailyTasks();
//        Assertions.assertEquals(2, result.size());
//        Assertions.assertEquals(DAILY_TASK_1_NAME, result.get(0).getName());
//        Assertions.assertEquals(DAILY_TASK_2_NAME, result.get(1).getName());
//    }
}
