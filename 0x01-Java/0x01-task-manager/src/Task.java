public class Task {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private TaskStatus taskStatus = TaskStatus.LOW;

    private TaskPriority taskPriority = TaskPriority.IN_PROGRESS;

    public Task(
            Long id,
            String title,
            String description,
            boolean completed,
            TaskStatus taskStatus,
            TaskPriority taskPriority) {

        if (title == null || title.isBlank()) // Correction from mentor
            throw new IllegalArgumentException("A task must have a title");
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void complete() {
        this.completed = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", taskStatus=" + taskStatus +
                ", taskPriority=" + taskPriority +
                '}';
    }
}
