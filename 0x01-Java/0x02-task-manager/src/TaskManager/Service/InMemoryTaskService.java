package TaskManager.Service;

import TaskManager.Exception.IllegalTaskException;
import TaskManager.Exception.TaskNotFoundException;
import TaskManager.Model.Task;
import TaskManager.Model.TaskPriority;
import TaskManager.Model.TaskStatus;
import TaskManager.Repository.InMemoryTaskRepository;

import java.util.List;

public class InMemoryTaskService implements TaskService {

    private final InMemoryTaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();

    public InMemoryTaskService() {
    }

    @Override
    public Task save(Task task) {
        // Special case: When title is empty or null
        if (task.getTitle().isBlank() || task.getTitle().isEmpty()) {
            throw new IllegalTaskException("A task must have a title. " +
                    "Add a title and try again.");
        }

        // Special case: Prevent duplicate task id
        boolean exist = inMemoryTaskRepository.existById(task.getId()).isPresent();
        if (exist) {
            throw new IllegalTaskException("This task already exists.");
        }
        return inMemoryTaskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return inMemoryTaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(
                        "The task with id '" + id + "' does not exist."));
    }

    @Override
    public List<Task> findAll() {
        return inMemoryTaskRepository.findAll()
                .orElseThrow(() -> new TaskNotFoundException("There are no tasks available for now. " +
                        "Try again later."));
    }

    @Override
    public Task updateByStatus(Task task) {
        return inMemoryTaskRepository.updateByStatus(task)
                .orElseThrow(() -> new TaskNotFoundException(
                        "This task does not exist."
                ));
    }

    @Override
    public List<Task> filterByStatus(TaskStatus status) {
        return inMemoryTaskRepository.filterByStatus(status)
                .orElseThrow(() -> new TaskNotFoundException("There are no tasks with the status of '" + status.name()));
    }

    @Override
    public List<Task> filterByPriority(TaskPriority priority) {
        return inMemoryTaskRepository.filterByPriority(priority)
                .orElseThrow(() -> new TaskNotFoundException("There are no tasks with the status of '" + priority.name()));
    }

    @Override
    public Boolean existById(Long id) {
        return inMemoryTaskRepository.existById(id)
                .orElseThrow(() -> new IllegalTaskException("This task already exists."));
    }
}
