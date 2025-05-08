package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.dto.TaskTrackerDTO;
import com.todoapp.todoapp.exception.TaskException;
import com.todoapp.todoapp.service.TaskTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
