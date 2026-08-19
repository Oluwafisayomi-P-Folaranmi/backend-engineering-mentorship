import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ----------- Start up a task manager -----------
        TaskManager taskTaskManager;
        taskTaskManager = startUpTaskManager();

        // ----------- Display tasks -----------
        // taskTaskManager.showTasks();

        // ----------- Find a task by your choice "id" -----------
        // Task task;
        // task = taskTaskManager.findByTaskId(2L);
        // System.out.println(task);

        // ----------- Find a task by your choice "task priority" -----------
        List<Task> tasksList = new ArrayList<>();
        tasksList = taskTaskManager
                .filterTasksByPriorityUsing(TaskPriority.COMPLETED);
        // Display the filtered list of tasks
        taskTaskManager.showTasks(tasksList);

    }

    /**
     * This is a utility method that helps start up a hardcoded task manager
     * @return the task manager
     */
    public static TaskManager startUpTaskManager() {
        TaskManager taskTaskManager;
        Task task1 = new Task(1L, "Personal Hygiene", "Brush my teeth.", true, TaskStatus.LOW, TaskPriority.IN_PROGRESS);
        Task task2 = new Task(2L, "Food", "Cook breakfast.", true, TaskStatus.HIGH, TaskPriority.COMPLETED);
        Task task3 = new Task(3L, "Work", "Go to work.", true, TaskStatus.LOW, TaskPriority.IN_PROGRESS);

        // Initialise the task manager
        taskTaskManager = new TaskManager();
        // Add the tasks
        taskTaskManager.addTask(task1);
        taskTaskManager.addTask(task2);
        taskTaskManager.addTask(task3);

        return taskTaskManager;
    }
}
