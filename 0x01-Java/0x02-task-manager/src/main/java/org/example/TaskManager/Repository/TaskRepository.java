package org.example.TaskManager.Repository;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    Optional<List<Task>> findAll();

    Optional<Task> updateByStatus(Task task, TaskStatus status);

    Optional<List<Task>> filterByStatus(TaskStatus status);

    Optional<List<Task>> filterByPriority(TaskPriority priority);

    Optional<Boolean> existById(Long id);

    Optional<Task> delete(Task task);
}
