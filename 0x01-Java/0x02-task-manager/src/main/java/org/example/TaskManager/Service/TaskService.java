package org.example.TaskManager.Service;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;

import java.util.List;

public interface TaskService {

    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    Task updateByStatus(Task task, TaskStatus status);

    List<Task> filterByStatus(TaskStatus status);

    List<Task> filterByPriority(TaskPriority priority);

    Boolean existById(Long id);

    Task delete(Task task);
}
