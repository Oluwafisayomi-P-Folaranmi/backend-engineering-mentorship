package org.example.TaskManager;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;
import org.example.TaskManager.Repository.InMemoryTaskRepository;
import org.example.TaskManager.Service.InMemoryTaskService;
import org.example.TaskManager.Service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {

    @Nested
    @DisplayName("Given a task manager")
    public class TaskManager {

        private InMemoryTaskService inMemoryTaskService;
        private List<Task> taskList;
        private Task task1;
        private Task task2;
        private Task task3;
        private Task task4;

        @BeforeEach
        public void setUp() {
            inMemoryTaskService = new InMemoryTaskService(new InMemoryTaskRepository());
            task1 = new Task(1L, "Write code", false,TaskStatus.IN_PROGRESS, TaskPriority.LOW);
            task2 = new Task(2L, "Review pull request", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
            task3 = new Task(3L, "Fix database connection", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
            task4 = new Task(4L, "Write unit tests", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);

            taskList = new ArrayList<>();
            List<Task> taskList = new ArrayList<>();
            taskList.add(task1);
            taskList.add(task2);
            taskList.add(task3);

            for (int i = 0; i < 3; i++) {
                inMemoryTaskService.save(taskList.get(i));
            }

        }

        @Test
        @DisplayName("When we want to create, find, and delete a task")
        public void testCreation() {
            assertAll(
                    "Here we test to create, find, and delete a task.",
                    () -> assertEquals(task4, inMemoryTaskService.save(task4)),
                    () -> assertEquals(task4, inMemoryTaskService.findById(4L)),
                    () -> assertTrue(inMemoryTaskService.existById(task4.getId())),
                    () -> assertEquals(task4, inMemoryTaskService.delete(task4))
            );
        }

        @Test
        @DisplayName((
                "When we want to manager more tasks: " +
                "create, find particular a task, find all tasks."))
        public void testManagingManyTasks() {

            assertAll(
                    "We test on many tasks",
                    () -> assertEquals(3, inMemoryTaskService.findAll().size()),
                    () -> assertEquals(2L, inMemoryTaskService.findAll().get(1).getId()),
                    () -> assertEquals(task1, inMemoryTaskService.delete(task1)),
                    () -> assertEquals(2, inMemoryTaskService.findAll().size())
            );
        }

        @Test
        @DisplayName("When we want to perform some changes on a task")
        public void testChangesToTask() {

            assertAll(
                    "We want to test a task features",
                    () -> assertEquals(TaskPriority.LOW, inMemoryTaskService.findById(2L).getPriority()),
                    () -> assertEquals(TaskStatus.IN_PROGRESS, inMemoryTaskService.findById(2L).getStatus()),
                    () -> assertEquals(task2, inMemoryTaskService.updateByStatus(task2, TaskStatus.COMPLETED)),
                    () -> assertEquals(TaskStatus.COMPLETED, task2.getStatus())
            );
        }
    }
}
