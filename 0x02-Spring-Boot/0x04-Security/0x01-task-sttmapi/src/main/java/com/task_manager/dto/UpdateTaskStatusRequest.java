package com.task_manager.dto;

import com.task_manager.data.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskStatusRequest(
        @NotNull
        TaskStatus taskStatus
) {
}
