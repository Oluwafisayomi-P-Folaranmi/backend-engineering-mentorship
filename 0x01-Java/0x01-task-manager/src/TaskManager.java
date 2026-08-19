import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskManager<I> {

    public List<I> items;

    public TaskManager() {
        this.items = new ArrayList<>();
    }

    // ------------------ Access methods ------------------
    /**
     * This method shows the list of tasks.
     * shows the list of tasks.
     */
    public void showTask() {
        int taskSize = this.items.size();
        int itemsStart = 0;
        int itemsEnd = taskSize;
        for (int i = itemsStart; i < itemsEnd; i++) {
            System.out.println(this.items.get(i));
        }
    }

    /**
     * This method finds a task by id.
     * shows the list of tasks.
     * @return a task
     */
    public I findByItemId(Long id) {
        Long itemId = id;
        I task = null;

        int taskSize = this.items.size();
        int itemsStart = 0;
        int itemsEnd = taskSize;

        for (int i = itemsStart; i < itemsEnd; i++) {

            if (id == items.get(i)) {
                task = items.get(i);
            }
        }

        if (task == null) {
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
    public List<I> filterTasksByPriorityUsingCollections(TaskPriority taskPriority) {

        List<I> list;

        int taskSize = this.items.size();
        int itemsStart = 0;
        int itemsEnd = taskSize;

        for (int i = itemsStart; i < itemsEnd; i++) {

            I task = items.get(i);

            if (taskPriority == items.get(i)) {
                task = items.get(i);
            }
        }
        return null;
    }

    /**
     * This method filters the tasks by "priority" using streams.
     * shows the list of tasks.
     * @return lists of filtered tasks
     */
    public List<I> filterTasksByPriorityUsingStream(TaskPriority taskPriority) {

        return null;
    }

    // ------------------ Update methods ------------------
    /**
     * This method add a task to the list of tasks.
     */
    public void addTask(I item) {
        items.add(item);
    }
}
