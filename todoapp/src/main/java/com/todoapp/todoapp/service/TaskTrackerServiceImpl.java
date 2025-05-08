package com.todoapp.todoapp.service;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.entity.Status;
import com.todoapp.todoapp.entity.TaskTracker;
import com.todoapp.todoapp.exception.TaskException;
import com.todoapp.todoapp.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTrackerServiceImpl implements TaskTrackerService{

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Integer addTask(TaskTrackerDTO taskDTO) throws TaskException {
        TaskTracker taskTracker = new TaskTracker();
        taskTracker.setTaskName(taskDTO.getTaskName());
        taskTracker.setTaskDescription(taskDTO.getTaskDescription());
        taskTracker.setTaskStatus(taskDTO.getTaskStatus());
        taskRepo.save(taskTracker);
        return taskTracker.getTaskId();
    }

    @Override
    public String updateTask(Integer taskId, String taskDescription) throws TaskException {
        return "";
    }

    @Override
    public String updateTaskStatus(Integer taskId, Status status) throws TaskException {
        return "";
    }

    @Override
    public Integer deleteTask(Integer taskId) throws TaskException {
        return 0;
    }

    @Override
    public TaskTrackerDTO getTask(Integer taskId) throws TaskException {
        return null;
    }

    @Override
    public List<TaskTrackerDTO> getAllTasks() throws TaskException {
        return List.of();
    }

    @Override
    public List<TaskTrackerDTO> getNotDoneTasks() throws TaskException {
        return List.of();
    }

    @Override
    public List<TaskTrackerDTO> getDoneTasks() throws TaskException {
        return List.of();
    }

    @Override
    public List<TaskTrackerDTO> getInProgressTasks() throws TaskException {
        return List.of();
    }
}
