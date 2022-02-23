package com.anubis.core.service.task;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;

import java.util.List;

public interface TaskService<T extends Task> {

    T createTask(T task);

    List<T> getAllTasks();

//    List<T> getTasksByDiscriminator();

    List<T> getTasksForFamilyMember(FamilyMember familyMemberId);
}
