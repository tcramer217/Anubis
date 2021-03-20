package com.anubis.core.dao;

import com.anubis.core.constants.TaskType;
import com.anubis.core.entity.family.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DisplayName("Verify the functionality of the TaskType.")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepoTestDB {

    private static final String TASK_NAME = "Task Name";
    private static final String TASK_NAME_1 = TASK_NAME + " 1";

    private TaskRepo<Task> taskRepo;

    @Test
    @Rollback(false)
    public void createTask() {
        Task task = new Task(TASK_NAME_1);

        Task createdTask = getTaskRepo().save(task);
        Assertions.assertEquals(TASK_NAME_1, createdTask.getName());
        Assertions.assertEquals(TaskType.Discriminator.BASE, createdTask.getDiscriminator());
    }

    @Autowired
    public TaskRepo<Task> getTaskRepo() {
        return taskRepo;
    }

    public void setTaskRepo(TaskRepo<Task> taskRepo) {
        this.taskRepo = taskRepo;
    }
}
