package org.example.TaskManager.Model;

import org.example.TaskManager.Repository.InMemoryTaskRepository;
import org.example.TaskManager.Service.InMemoryTaskService;
import org.example.TaskManager.Service.TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private TaskService taskService = new InMemoryTaskService(new InMemoryTaskRepository());
    private final Task task = new Task(1L, "Write code", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);

    @Test
    public void testTask() {
        assertAll(
                () -> assertEquals(1L, task.getId()),
                () -> assertEquals("Write code", task.getTitle()),
                () -> assertFalse(task.isCompleted()),
                () -> assertEquals(TaskStatus.IN_PROGRESS, task.getStatus()),
                () -> assertEquals(TaskPriority.LOW, task.getPriority())
        );
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
