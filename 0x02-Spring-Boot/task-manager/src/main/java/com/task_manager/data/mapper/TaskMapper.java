package com.task_manager.data.mapper;

import com.task_manager.data.model.Task;
import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.TaskResponse;
import com.task_manager.utils.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(CreateTaskRequest createTaskRequest) {
        return new Task(createTaskRequest.title(),
                StringUtils.normalizeString(createTaskRequest.description()),
                createTaskRequest.taskPriority()
        );
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }
}
