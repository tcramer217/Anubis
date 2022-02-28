package com.anubis.core.service.task;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;

import java.util.List;

public interface TaskService<T extends Task> {

    T createTask(T task);
    T findById(long taskId);
    void markTaskCompleted(long taskId);
    void markTaskIncomplete(long taskId);

    List<T> getAllTasks();

    List<T> getTasksForFamilyMember(FamilyMember familyMemberId);
}
