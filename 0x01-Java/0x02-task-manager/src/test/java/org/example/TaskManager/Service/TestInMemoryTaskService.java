package org.example.TaskManager.Service;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;
import org.example.TaskManager.Repository.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInMemoryTaskService {

    private TaskService taskService = new InMemoryTaskService(new InMemoryTaskRepository());
    private final Task task = new Task(2L, "Write code", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);


    @Test
    public void testSave() {
        Task savedTask = taskService.save(task);
        assertEquals(task, savedTask);
    }

    @Test
    public void testFindById() {
        Task savedTask = taskService.save(task);
        Task searchedTask = taskService.findById(2L);
        assertEquals(task, searchedTask);

    }

    @Test
    public void testFindAll() {
        Task savedTask1 = taskService.save(new Task(1L, "Review pull request", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW));
        Task savedTask2 = taskService.save(new Task(2L, "Fix database connection", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW));
        Task savedTask3 = taskService.save(new Task(3L, "Write unit tests", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW));

        List<Task> expectedTaskList = List.of(savedTask1, savedTask2, savedTask3);
        List<Task> actualList = taskService.findAll();

    }

    @Test
    public void testUpdateByStatus() {
        Task savedTask = taskService.save(task);
        Task updatedTask = taskService.updateByStatus(savedTask, TaskStatus.COMPLETED);
        assertEquals(savedTask.getStatus(), updatedTask.getStatus());
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
