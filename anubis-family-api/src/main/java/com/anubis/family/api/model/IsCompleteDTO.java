package com.anubis.family.api.model;

public class IsCompleteDTO {

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
