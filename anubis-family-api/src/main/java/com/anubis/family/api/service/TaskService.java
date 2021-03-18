package com.anubis.family.api.service;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;

import java.util.List;

public interface TaskService<T extends Task> {

    T createTask(T task);

    List<T> getAllTasks();

//    List<T> getTasksByDiscriminator();

    List<T> getTasksForFamilyMember(FamilyMember familyMember);
}
