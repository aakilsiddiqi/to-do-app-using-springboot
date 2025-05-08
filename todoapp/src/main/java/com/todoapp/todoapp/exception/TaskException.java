package com.todoapp.todoapp.exception;

public class TaskException extends Exception{

    public TaskException(String msg){
        super(msg);
    }

    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }
}
