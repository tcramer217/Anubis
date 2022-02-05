package com.anubis.core.service.task;

import com.anubis.core.dao.TaskRepo;
import com.anubis.core.entity.family.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class TaskServiceImplTest {

    @Mock
    private TaskRepo<Task> taskRepoMock;

    @InjectMocks
    private TaskServiceImpl<Task> taskService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskServiceImpl<>(taskRepoMock);
    }

    @Test
    public void getAllTasks() {
        Task task1 = new Task("Test Task 1");
        Task task2 = new Task("Test Task 2");
        List<Task> tasks = Arrays.asList(task1, task2);
        when(taskRepoMock.findAllTasks()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();
        Assertions.assertEquals(2, result.size());
    }
}
