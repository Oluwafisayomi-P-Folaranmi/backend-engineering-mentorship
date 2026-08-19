import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    public List<Task> tasksList;

    public int size = 0;

    public TaskManager() {
        this.tasksList = new ArrayList<>();
    }

    // ------------------ Access methods ------------------
    /**
     * This method shows the list of tasks.
     * shows the list of tasks.
     */
    public void showTasks() {
        System.out.println("There are '" + size + "' tasks in this manager: \n");

        int itemsStart = 0, itemsEnd = size - 1;

        for (int i = itemsStart; i <= itemsEnd; i++) {
            System.out.println(this.tasksList.get(i));
        }
    }

    /**
     * This method shows the list of tasks.
     * shows the list of tasks.
     */
    public void showTasks(List<Task> tasks) {
        int size = tasks.size();
        System.out.println("There are '" + size + "' tasks in this manager: \n");

        int itemsStart = 0, itemsEnd = size - 1;

        for (int i = itemsStart; i <= itemsEnd; i++) {
            System.out.println(tasks.get(i));
        }
    }

    /**
     * This method finds a task by id.
     * shows the list of tasks.
     * @return a task
     */
    public Task findByTaskId(Long id) {

        Task task = null;

        int itemsStart = 0, itemsEnd = size - 1;

        for (int i = itemsStart; i <= itemsEnd; i++) {
            Long tId = tasksList.get(i).getId();
            if (id == tId) {
                task = tasksList.get(i);
            }
        }

        if (task != null) {
            return task;
        }
        else {
            return null;
        }
    }

    /**
     * This method filters the tasks by "priority" using collections.
     * shows the list of tasks.
     * @return lists of filtered tasks
     */
    public List<Task> filterTasksByPriorityUsing(TaskPriority taskPriority) {

        List<Task> resultList = new ArrayList<>();

        int itemsStart = 0, itemsEnd = size - 1;

        for (int i = itemsStart; i <= itemsEnd; i++) {
            TaskPriority theTaskPriority = tasksList.get(i).getTaskPriority();

            if (taskPriority == theTaskPriority) {
                resultList.add(tasksList.get(i));
            }
        }
        return resultList;
    }

    // ------------------ Update methods ------------------
    /**
     * This method add a task to the list of tasks.
     */
    public void addTask(Task task) {
        tasksList.add(task);
        size++;
    }
}
