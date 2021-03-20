package com.anubis.core.constants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Verify the functionality of the TaskType.")
class TaskTypeTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @EnumSource(TaskType.class)
    @DisplayName("Get Endpoint")
    void taskType(TaskType taskType) {
        int taskTypeId = taskType.getId();
        String taskTypeEndpoint = taskType.getEndpoint();

        TaskType fetchedType = TaskType.getById(taskTypeId);
        assertEquals(taskType, fetchedType);
        assertEquals(taskTypeId, fetchedType.getId());
        assertEquals(taskTypeEndpoint, fetchedType.getEndpoint());
    }

    @ParameterizedTest
    @EnumSource(TaskType.class)
    @DisplayName("Get TaskType By Id")
    void getById(TaskType taskType) {
        int taskTypeId = taskType.getId();
        TaskType fetchedType = TaskType.getById(taskTypeId);
        assertEquals(taskType, fetchedType);
        assertEquals(taskTypeId, fetchedType.getId());
    }

    @ParameterizedTest
    @EnumSource(TaskType.class)
    @DisplayName("Get TaskType By Name")
    void getByName(TaskType taskType) {
        String taskTypeName = taskType.getName();
        TaskType fetchedType = TaskType.getByName(taskTypeName);
        assertEquals(taskType, fetchedType);
        assertEquals(taskTypeName, fetchedType.getName());
    }

    @ParameterizedTest
    @EnumSource(TaskType.class)
    @DisplayName("Get TaskType By Discriminator")
    void getByDiscriminator(TaskType taskType) {
        String taskTypeDiscriminator = taskType.getDiscriminator();
        TaskType fetchedType = TaskType.getByDiscriminator(taskTypeDiscriminator);
        assertEquals(taskType, fetchedType);
        assertEquals(taskTypeDiscriminator, fetchedType.getDiscriminator());
    }

    @ParameterizedTest
    @MethodSource("getDiscriminators")
    @DisplayName("Verify Discriminator subclass")
    void getDiscriminatorConstants(String expectedDiscriminator) {
        assertEquals(expectedDiscriminator, TaskType.getByDiscriminator(expectedDiscriminator).getDiscriminator());
    }

    @ParameterizedTest
    @MethodSource("getNames")
    @DisplayName("Verify Name subclass")
    void getNameConstants(String expectedName) {
        assertEquals(expectedName, TaskType.getByName(expectedName).getName());
    }

    private static Stream<Arguments> getDiscriminators() {
        List<Arguments> args = new ArrayList<>();
        TaskType.Discriminator.getDiscriminators()
                .forEach((discriminator) -> {
                    args.add(Arguments.of(discriminator));
                });
        Stream<Arguments> arguments = args.stream();
        return arguments;
    }

    private static Stream<Arguments> getNames() {
        List<Arguments> args = new ArrayList<>();
        TaskType.Name.getNames()
                .forEach((name) -> {
                    args.add(Arguments.of(name));
                });
        Stream<Arguments> arguments = args.stream();
        return arguments;
    }
}
