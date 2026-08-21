import TaskManager.Model.Task;
import TaskManager.Model.TaskPriority;
import TaskManager.Model.TaskStatus;
import TaskManager.Service.InMemoryTaskService;
import TaskManager.Service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ----------------------------- The task manager -----------------------------
        TaskService taskService = new InMemoryTaskService();

        // ----------------------------- Save task -----------------------------
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Created a few tasks.");
        Task task1 = new Task(1L, "Write code", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
        Task task2 = new Task(2L, "Review pull request", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
        Task task3 = new Task(7L, "Fix database connection", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
        Task task4 = new Task(4L, "Write unit tests", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);
        Task task5 = new Task(5L, "Update documentation", false, TaskStatus.IN_PROGRESS, TaskPriority.LOW);

        Task savedTask1 = taskService.save(task1);
        Task savedTask2 = taskService.save(task2);
        Task savedTask3 = taskService.save(task3);
        Task savedTask4 = taskService.save(task4);
        Task savedTask5 = taskService.save(task5);

        // ----------------------------- Find all tasks -----------------------------
        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("The tasks are:");
        List<Task> tasks = new ArrayList<>();
        tasks = taskService.findAll();
        for (Task task : tasks) {
            System.out.println(task);
        }

        // ----------------------------- Find task by id -----------------------------
        Long theId = 2L;
        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("The task with the id '" + theId + "' is:");
        Task resultTask = taskService.findById(2L);
        System.out.println(resultTask);

        // ----------------------------- Update a task -----------------------------
        System.out.println("\n--------------------------------------------------------------------------------------");
        Task aTask = taskService.findById(2L);
        System.out.println("The task before status update: " + aTask);

        Task resultTask2 = taskService.updateByStatus(aTask);
        System.out.println("The task after status update: " + resultTask2);

        // ----------------------------- Filter tasks by status -----------------------------
        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("The task with status of '" + TaskStatus.IN_PROGRESS.name() + "' are: ");
        List<Task> filteredTaskByStatus = taskService.filterByStatus(TaskStatus.IN_PROGRESS);
        for (Task task : filteredTaskByStatus) {
            System.out.println(task);
        }

        // ----------------------------- Filter tasks by priority -----------------------------
        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("The task with status of '" + TaskPriority.LOW.name() + "' are: ");
        List<Task> filteredTaskByPriority = taskService.filterByPriority(TaskPriority.LOW);
        for (Task task : filteredTaskByStatus) {
            System.out.println(task);
        }
    }
}
