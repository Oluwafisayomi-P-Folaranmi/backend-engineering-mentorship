package com.task_manager.dto;

import com.task_manager.data.enums.TaskPriority;
import com.task_manager.data.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        String taskId,
        String title,
        String description,
        TaskPriority taskPriority,
        TaskStatus taskStatus,
        LocalDateTime createdAt
) {
}
