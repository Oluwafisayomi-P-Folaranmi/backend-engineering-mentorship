package TaskManager.Repository;

import TaskManager.Model.Task;
import TaskManager.Model.TaskPriority;
import TaskManager.Model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(Long id);

    Optional<List<Task>> findAll();

    Optional<Task> updateByStatus(Task task);

    Optional<List<Task>> filterByStatus(TaskStatus status);

    Optional<List<Task>> filterByPriority(TaskPriority priority);

    Optional<Boolean> existById(Long id);
}
