package com.task_manager.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError(
        LocalDateTime timestamp, int status, String code, String message, String path, Map<String, String> fieldErrors
) {
}
