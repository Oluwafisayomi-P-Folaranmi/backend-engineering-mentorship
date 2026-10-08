package com.task_manager.dto;

import com.task_manager.data.enums.TaskPriority;
import com.task_manager.data.enums.TaskStatus;

public record UpdateTaskRequest(
        String taskId,
        String title,
        String description,
        TaskPriority taskPriority,
        TaskStatus taskStatus
) {
}
