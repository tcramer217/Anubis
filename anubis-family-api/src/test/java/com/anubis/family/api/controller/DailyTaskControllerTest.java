package com.anubis.family.api.controller;

import com.anubis.family.api.service.TaskService;
import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.WeeklyTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DailyTaskControllerTest {

    private static final String TASK_1_NAME = "TODO 1";
    private static final String TASK_2_NAME = "TODO 2";

    @Mock
    TaskService<DailyTask> dailyTaskService;

    @Mock
    TaskService<WeeklyTask> weeklyTaskTaskService;

    @InjectMocks
    DailyTaskController dailyTaskController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void getDailyTaskCount() {
        DailyTask dt1 = new DailyTask(TASK_1_NAME);
        DailyTask dt2 = new DailyTask(TASK_2_NAME);

        when(dailyTaskService.getDailyTasks()).thenReturn(Arrays.asList(dt1, dt2));

        Integer result = dailyTaskController.getDailyTaskCount();
        Assertions.assertEquals(2, result);
    }
}
