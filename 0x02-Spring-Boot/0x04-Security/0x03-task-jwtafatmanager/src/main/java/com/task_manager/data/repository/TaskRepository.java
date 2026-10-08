package com.task_manager.data.repository;

import com.task_manager.data.enums.TaskPriority;
import com.task_manager.data.enums.TaskStatus;
import com.task_manager.data.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    Page<Task> findByPriority(TaskPriority priority, Pageable pageable);
    Page<Task> findByStatusAndPriority(TaskStatus status, TaskPriority priority, Pageable pageable);
    Optional<Task> findByTaskId(String taskId);
    boolean existsByTitle(String title);
}
