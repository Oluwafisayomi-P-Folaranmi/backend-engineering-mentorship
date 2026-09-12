package com.task_manager.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String taskId) {
        super("Task with id '" + taskId + "' not found");
    }
}
