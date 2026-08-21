package TaskManager.Model;

import java.time.LocalDateTime;

public class Task {

    private Long id;

    private String title;

    private boolean completed;

    private TaskStatus status;

    private TaskPriority priority;

    private final LocalDateTime dateTime = LocalDateTime.now();;

    public Task(Long id, String title, boolean completed, TaskStatus status, TaskPriority priority) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted(boolean completed) {
        this.completed = completed;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", status=" + status +
                ", priority=" + priority +
                ", dateTime=" + dateTime +
                '}';
    }
}
