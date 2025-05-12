package com.todoapp.todoapp.service;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.entity.Status;
import com.todoapp.todoapp.entity.TaskTracker;
import com.todoapp.todoapp.exception.TaskException;
import com.todoapp.todoapp.repo.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "taskService")
@Transactional
public class TaskTrackerServiceImpl implements TaskTrackerService {

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Integer addTask(TaskTrackerDTO taskDTO) throws TaskException {
        TaskTracker taskTracker = new TaskTracker();
        taskTracker.setTaskName(taskDTO.getTaskName());
        taskTracker.setTaskDescription(taskDTO.getTaskDescription());
        taskTracker.setStatus(taskDTO.getTaskStatus());
        taskRepo.save(taskTracker);
        return taskTracker.getTaskId();
    }

    @Override
    public void updateTask(Integer taskId, String taskDescription) throws TaskException {
        if (null == taskId) {
            throw new TaskException("Task ID not provided !!!!");
        }
        Optional<TaskTracker> task = taskRepo.findById(taskId);
        TaskTracker tracker = task.orElseThrow(()->new TaskException("No Records Found from this Task ID !!!!"));
        tracker.setTaskDescription(taskDescription);
    }

    @Override
    public void updateTaskStatus(Integer taskId, Status status) throws TaskException {
        if (null == taskId) {
            throw new TaskException("Task ID not provided !!!!");
        }
        Optional<TaskTracker> task = taskRepo.findById(taskId);
        TaskTracker tracker = task.orElseThrow(()->new TaskException("No Records Found from this Task ID !!!!"));
        tracker.setStatus(status);
    }

    @Override
    public void deleteTask(Integer taskId) throws TaskException {
        if (null == taskId) {
            throw new TaskException("Task ID not provided !!!!");
        }
        Optional<TaskTracker> task = taskRepo.findById(taskId);
        task.orElseThrow(()->new TaskException("No Records Found from this Task ID !!!!"));
        taskRepo.deleteById(taskId);
    }

    @Override
    public Optional<TaskTracker> getTask(Integer taskId) throws TaskException {
        Optional<TaskTracker> taskTracker = taskRepo.findById(taskId);
        if (taskTracker.isEmpty()) {
            throw new TaskException("No Record found from this Task ID !!!!");
        }
        return taskTracker;
    }

    @Override
    public List<TaskTracker> getAllTasks() throws TaskException {
        List<TaskTracker> taskTrackers = (List<TaskTracker>) taskRepo.findAll();
        if (taskTrackers.isEmpty()) {
            throw new TaskException("No Records Found !!!");
        }
        return taskTrackers;
    }

    @Override
    public List<TaskTracker> getNotDoneTasks() throws TaskException {
        List<TaskTracker> notDoneTasks = taskRepo.findByStatus(Status.NOT_DONE);
        if (notDoneTasks.isEmpty()) {
            throw new TaskException("No Records Found !!!!");
        }
        return notDoneTasks;
    }

    @Override
    public List<TaskTracker> getDoneTasks() throws TaskException {
        List<TaskTracker> doneTasks = taskRepo.findByStatus(Status.DONE);
        if (doneTasks.isEmpty()) {
            throw new TaskException("No Records Found !!!!");
        }
        return doneTasks;
    }

    @Override
    public List<TaskTracker> getInProgressTasks() throws TaskException {
        List<TaskTracker> inProgressTasks = taskRepo.findByStatus(Status.IN_PROGRESS);
        if (inProgressTasks.isEmpty()) {
            throw new TaskException("No Records Found !!!!");
        }
        return inProgressTasks;
    }
}
