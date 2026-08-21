package TaskManager.Service;

import TaskManager.Model.Task;
import TaskManager.Model.TaskPriority;
import TaskManager.Model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    Task updateByStatus(Task task);

    List<Task> filterByStatus(TaskStatus status);

    List<Task> filterByPriority(TaskPriority priority);

    Boolean existById(Long id);
}
