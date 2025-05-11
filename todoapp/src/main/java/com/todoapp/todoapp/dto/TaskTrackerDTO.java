package com.todoapp.todoapp.dto;

import com.todoapp.todoapp.entity.Status;

import java.util.Objects;

public class TaskTrackerDTO {

    private Integer taskId;
    private String taskName;
    private String taskDescription;
    private Status taskStatus;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskTrackerDTO{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskTrackerDTO that = (TaskTrackerDTO) o;
        return Objects.equals(taskName, that.taskName) && Objects.equals(taskDescription, that.taskDescription) && taskStatus == that.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, taskDescription, taskStatus);
    }
}
