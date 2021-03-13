package com.tcramer.anubis.core.dao;

import com.tcramer.anubis.core.entity.family.DailyTask;
import com.tcramer.anubis.core.entity.family.Task;
import com.tcramer.anubis.core.entity.family.WeeklyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo<T extends Task> extends JpaRepository<T, Long> {

    @Query("from DailyTask ")
    List<DailyTask> findDailyTasks();

    @Query("from WeeklyTask ")
    List<WeeklyTask> findWeeklyTasks();

}
