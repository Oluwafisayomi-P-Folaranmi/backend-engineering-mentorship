package org.example.TaskManager.Repository;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;
import org.example.TaskManager.Service.InMemoryTaskService;
import org.example.TaskManager.Service.TaskService;
import org.junit.jupiter.api.Test;

public class TestInMemoryTaskRepository {

    private TaskService taskService = new InMemoryTaskService(new InMemoryTaskRepository());
    private final Task task = new Task(1L, "Write code", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);


    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
