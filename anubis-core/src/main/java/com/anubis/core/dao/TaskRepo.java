package com.anubis.core.dao;

import com.anubis.core.entity.family.DailyTask;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;
import com.anubis.core.entity.family.WeeklyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo<T extends Task> extends JpaRepository<T, Long> {

//    @Query("FROM Task WHERE task_type = ?1 ")
//    List<T>  findTasksByDiscriminator(String discriminator);
    T findTaskById(long id);

    @Query("select t from Task t")
    List<T> findAllTasks();

    @Query("from WeeklyTask ")
    List<WeeklyTask> findWeeklyTasks();

    @Query("SELECT t FROM WeeklyTask t LEFT JOIN FamilyMember fm on t.assignedTo.id = fm.id " +
            "WHERE fm.familyId = :familyId ORDER BY t.isComplete, t.createdAt")
    List<WeeklyTask> findWeeklyTasksForFamily(long familyId);

    @Query("SELECT t FROM WeeklyTask t WHERE t.assignedTo = :familyMemberId ORDER BY t.isComplete, t.createdAt")
    List<WeeklyTask> findWeeklyTasksForFamilyMember(FamilyMember familyMemberId);

    @Query("from DailyTask ")
    List<DailyTask> findDailyTasks();

    @Query("SELECT t FROM DailyTask t LEFT JOIN FamilyMember fm on t.assignedTo.id = fm.id " +
            "WHERE fm.familyId = :familyId ORDER BY t.isComplete, t.createdAt")
    List<DailyTask> findDailyTasksForFamily(long familyId);

    @Query("SELECT t FROM DailyTask t WHERE t.assignedTo = :familyMemberId ORDER BY t.isComplete, t.createdAt")
    List<DailyTask> findDailyTasksForFamilyMember(FamilyMember familyMemberId);

}
