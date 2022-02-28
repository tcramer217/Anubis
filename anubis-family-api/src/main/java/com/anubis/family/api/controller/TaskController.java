package com.anubis.family.api.controller;

import com.anubis.core.constants.TaskType;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.family.Task;
import com.anubis.core.service.task.TaskService;
import com.anubis.family.api.model.User;
import com.anubis.family.api.model.response.MessageResponse;
import com.anubis.family.api.service.family.FamilyMemberService;
import com.anubis.family.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService<Task> taskService;

    @Autowired
    FamilyMemberService familyMemberService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public List<Task> getTasks() {
        return getTaskService().getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return getTaskService().createTask(task);
    }

    @GetMapping("/types")
    public TaskType[] getTaskTypes() {
        return TaskType.values();
    }

    @GetMapping("/types/name")
    public List<String> getTaskTypeNames() {
        return TaskType.Name.getNames();
    }

    protected static class IsCompleteDTO {
        private boolean isComplete;
        private long taskId;

        public IsCompleteDTO() {
        }

        public boolean getIsComplete() {
            return isComplete;
        }

        public void setIsComplete(boolean complete) {
            isComplete = complete;
        }

        public long getTaskId() {
            return taskId;
        }

        public void setTaskId(long taskId) {
            this.taskId = taskId;
        }
    }

    @PostMapping("/complete")
    public ResponseEntity<?> markTaskComplete(@RequestBody IsCompleteDTO isComplete) {
        if (isComplete.getTaskId() > 0) {
            if (isComplete.getIsComplete()) {
                getTaskService().markTaskCompleted(isComplete.getTaskId());
            } else {
                getTaskService().markTaskIncomplete(isComplete.getTaskId());
            }
            return ResponseEntity.ok().body(new MessageResponse("Successful Update to Task Completion Status."));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public JwtUtil getJwtUtil() {
        return jwtUtil;
    }

    public FamilyMemberService getFamilyMemberService() {
        return familyMemberService;
    }

    public TaskService<Task> getTaskService() {
        return taskService;
    }
}
