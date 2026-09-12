package com.task_manager.exception;

public class DuplicateTaskException extends RuntimeException {

    public DuplicateTaskException(String title) {
        super("Task with title '" + title + "' exists.");
    }
}
