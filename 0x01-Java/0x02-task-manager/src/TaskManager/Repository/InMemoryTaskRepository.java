package TaskManager.Repository;

import TaskManager.Model.Task;
import TaskManager.Model.TaskPriority;
import TaskManager.Model.TaskStatus;

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
    public Optional<Task> updateByStatus(Task task) {
        Long taskId = task.getId();
        for (Task theTask : tasks) {
            if (theTask.getId() == taskId) {
                theTask.markCompleted(true);
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
}
