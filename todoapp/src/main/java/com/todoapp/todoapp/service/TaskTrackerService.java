package com.todoapp.todoapp.service;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.entity.Status;
import com.todoapp.todoapp.entity.TaskTracker;
import com.todoapp.todoapp.exception.TaskException;

import java.util.List;
import java.util.Optional;

public interface TaskTrackerService {

    public Integer addTask(TaskTrackerDTO taskDTO) throws TaskException;

    public void updateTask(Integer taskId, String taskDescription) throws TaskException;

    public void updateTaskStatus(Integer taskId, Status status) throws TaskException;

    public void deleteTask(Integer taskId) throws TaskException;

    public Optional<TaskTracker> getTask(Integer taskId) throws TaskException;

    public List<TaskTracker> getAllTasks() throws TaskException;

    public List<TaskTracker> getNotDoneTasks() throws TaskException;

    public List<TaskTracker> getDoneTasks() throws TaskException;

    public List<TaskTracker> getInProgressTasks() throws TaskException;
}
