package com.todoapp.todoapp.service;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.entity.Status;
import com.todoapp.todoapp.exception.TaskException;

import java.util.List;

public interface TaskTrackerService {

    public Integer addTask(TaskTrackerDTO taskDTO) throws TaskException;

    public String updateTask(Integer taskId, String taskDescription) throws TaskException;

    public String updateTaskStatus(Integer taskId, Status status) throws TaskException;

    public Integer deleteTask(Integer taskId) throws TaskException;

    public TaskTrackerDTO getTask(Integer taskId) throws TaskException;

    public List<TaskTrackerDTO> getAllTasks() throws TaskException;

    public List<TaskTrackerDTO> getNotDoneTasks() throws TaskException;

    public List<TaskTrackerDTO> getDoneTasks() throws TaskException;

    public List<TaskTrackerDTO> getInProgressTasks() throws TaskException;
}
