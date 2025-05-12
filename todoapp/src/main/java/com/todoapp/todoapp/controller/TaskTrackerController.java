package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.entity.Status;
import com.todoapp.todoapp.entity.TaskTracker;
import com.todoapp.todoapp.exception.TaskException;
import com.todoapp.todoapp.service.TaskTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskTrackerController {

    @Autowired
    private TaskTrackerService taskTrackerService;

    @PostMapping(value = "/addTask")
    public ResponseEntity<String> addTask(@RequestBody TaskTrackerDTO trackerDTO) throws TaskException{
        Integer taskId = taskTrackerService.addTask(trackerDTO);
        String msg = "Task is Created with " + taskId ;
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllTasks")
    public ResponseEntity<List<TaskTracker>> getAllTasks() throws TaskException{
        List<TaskTracker> allTasks  = taskTrackerService.getAllTasks();
        return new ResponseEntity<>(allTasks,HttpStatus.OK);
    }

    @GetMapping(value = "/getDoneTasks")
    public ResponseEntity<List<TaskTracker>> getDoneTasks() throws TaskException{
        List<TaskTracker> doneTasks  = taskTrackerService.getDoneTasks();
        return new ResponseEntity<>(doneTasks,HttpStatus.OK);
    }

    @GetMapping(value = "/getNotDoneTasks")
    public ResponseEntity<List<TaskTracker>> getNotDoneTasks() throws TaskException{
        List<TaskTracker> doneTasks  = taskTrackerService.getNotDoneTasks();
        return new ResponseEntity<>(doneTasks,HttpStatus.OK);
    }

    @GetMapping(value = "/getInProgressTasks")
    public ResponseEntity<List<TaskTracker>> getInProgressTasks() throws TaskException{
        List<TaskTracker> doneTasks  = taskTrackerService.getInProgressTasks();
        return new ResponseEntity<>(doneTasks,HttpStatus.OK);
    }
    @GetMapping(value = "/getTask/{taskId}")
    public ResponseEntity<Optional<TaskTracker>> getTaskById(@PathVariable Integer taskId) throws TaskException{
        Optional<TaskTracker> doneTasks  = taskTrackerService.getTask(taskId);
        return new ResponseEntity<>(doneTasks,HttpStatus.OK);
    }
    @PutMapping(value = "/updateTaskDetails/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Integer taskId, @RequestBody String taskDescription) throws TaskException {
        taskTrackerService.updateTask(taskId,taskDescription);
        String msg = "Task Detail Updated !!!! ";
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }
    @PatchMapping(value = "/updateTaskStatus/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Integer taskId, @RequestBody Status status) throws TaskException {
        taskTrackerService.updateTaskStatus(taskId,status);
        String msg = "Task Status Updated !!!! ";
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteTask/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) throws TaskException {
        taskTrackerService.deleteTask(taskId);
        String msg = "Task Deleted Successfully !!!! ";
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

}
