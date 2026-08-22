package org.example.TaskManager.Repository;

import org.example.TaskManager.Model.Task;
import org.example.TaskManager.Model.TaskPriority;
import org.example.TaskManager.Model.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTaskRepository implements TaskRepository {

    List<Task> tasks = new ArrayList<>();

    @Override
    public Task save(Task task) {
        tasks.add(task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Task>> findAll() {
        if (!(tasks.isEmpty())) {
            return Optional.of(tasks);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> updateByStatus(Task task, TaskStatus status) {
        Long taskId = task.getId();
        for (Task theTask : tasks) {
            if (theTask.getId() == taskId) {
                theTask.setStatus(status);
                return Optional.of(theTask);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Task>> filterByStatus(TaskStatus status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task theTask : tasks) {
            if (theTask.getStatus() == status) {
                filteredTasks.add(theTask);
            }
        }
        if (!(filteredTasks.isEmpty())) {
            return Optional.of(filteredTasks);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Task>> filterByPriority(TaskPriority priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task theTask : tasks) {
            if (theTask.getPriority() == priority) {
                filteredTasks.add(theTask);
            }
        }
        if (!(filteredTasks.isEmpty())) {
            return Optional.of(filteredTasks);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> existById(Long id) {
        for (Task theTask : tasks) {
            if (theTask.getId().equals(id)) {
                return Optional.of(Boolean.TRUE);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> delete(Task task) {
        Task deletedTask;
        for (Task theTask : tasks) {
            if (theTask.getId().equals(task.getId())) {
                deletedTask = theTask;
                tasks.remove(theTask);
                return Optional.of(theTask);
            }
        }
        return Optional.empty();
    }
}
