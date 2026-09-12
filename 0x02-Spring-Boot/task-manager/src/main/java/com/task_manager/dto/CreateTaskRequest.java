package com.task_manager.dto;

import com.task_manager.data.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(
        @NotBlank
        String title,
        String description,
        TaskPriority taskPriority
) {
}
