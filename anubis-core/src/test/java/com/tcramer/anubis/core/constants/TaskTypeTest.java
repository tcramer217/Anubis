package com.tcramer.anubis.core.constants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Verify the functionality of the TaskType.")
class TaskTypeTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @EnumSource(TaskType.class)
    void getById(TaskType taskType) {
        int taskTypeId = taskType.getId();
        TaskType fetchedType = TaskType.getById(taskTypeId);
        assertEquals(taskType, fetchedType);
        assertEquals(taskTypeId, fetchedType.getId());
    }
}
