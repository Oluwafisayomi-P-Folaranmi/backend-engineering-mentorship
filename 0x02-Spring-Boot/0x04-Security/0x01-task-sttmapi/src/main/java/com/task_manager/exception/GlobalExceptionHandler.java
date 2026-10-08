package com.task_manager.exception;

import com.task_manager.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiError> handleTaskNotFoundException(TaskNotFoundException exception,
                                                                HttpServletRequest request) {
        return buildError(HttpStatus.NOT_FOUND,
                "TASK_NOT_FOUND",
                exception.getMessage(),
                request.getRequestURI(),
                Map.of());
    }

    @ExceptionHandler(DuplicateTaskException.class)
    public ResponseEntity<ApiError> handleDuplicateTaskException(DuplicateTaskException exception,
                                                                 HttpServletRequest request) {
        return buildError(HttpStatus.CONFLICT,
                "TASK_EXISTS",
                exception.getMessage(),
                request.getRequestURI(),
                Map.of());
    }

    private ResponseEntity<ApiError> buildError(
            HttpStatus status,
            String code,
            String message,
            String path,
            Map<String, String> fieldErrors)
    {
        ApiError error = new ApiError(
                LocalDateTime.now(),
                status.value(),
                code,
                message,
                path,
                fieldErrors
        );

        return ResponseEntity.status(status).body(error);
    }
}
