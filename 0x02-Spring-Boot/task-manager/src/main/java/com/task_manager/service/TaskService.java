package com.task_manager.service;

import com.task_manager.data.enums.TaskPriority;
import com.task_manager.data.enums.TaskStatus;
import com.task_manager.data.mapper.TaskMapper;
import com.task_manager.data.model.Task;
import com.task_manager.data.repository.TaskRepository;
import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.TaskResponse;
import com.task_manager.dto.UpdateTaskRequest;
import com.task_manager.dto.UpdateTaskStatusRequest;
import com.task_manager.exception.DuplicateTaskException;
import com.task_manager.exception.TaskNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponse createTask(CreateTaskRequest createTaskRequest) {
        boolean exist = taskRepository.existsByTitle(createTaskRequest.title());
        if (exist) { // Checks if a task with the same title exists
            throw new DuplicateTaskException(createTaskRequest.title());
        }
        Task task = taskMapper.toEntity(createTaskRequest);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toResponse(savedTask);
    }

    public TaskResponse getTask(String taskId){
        return taskMapper.toResponse(findTask(taskId));
    }

    public Page<TaskResponse> getTasks(TaskStatus status, TaskPriority priority, Pageable pageable) {
        Page<Task> tasks;

        if(status != null && priority != null) {
            tasks = taskRepository.findByStatusAndPriority(status, priority, pageable);
        } else if( status != null) {
            tasks = taskRepository.findByStatus(status, pageable);
        } else if( priority != null) {
            tasks = taskRepository.findByPriority(priority, pageable);
        } else {
            tasks = taskRepository.findAll(pageable);
        }
        return tasks.map(taskMapper::toResponse);
    }

    // ----------------------------------------------- Update a Task -----------------------------------------------
    // ----------------------------------------------- Complete Update ---------------------------------------------
    public TaskResponse putTask(UpdateTaskRequest request,
                                String taskId) {
        Optional<Task> optionalTask = taskRepository.findByTaskId(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        Task savedTask = optionalTask.get();

        savedTask.setTitle(request.title());
        savedTask.setDescription(request.description());
        savedTask.setPriority(request.taskPriority());
        savedTask.setStatus(request.taskStatus());

        return taskMapper.toResponse(taskRepository.save(savedTask));
    }

    // ----------------------------------------------- Update a Task -----------------------------------------------
    // ----------------------------------------------- Partial Update ----------------------------------------------
    public TaskResponse patchTask(UpdateTaskRequest request,
                                  String taskId) {
        Optional<Task> optionalTask = taskRepository.findByTaskId(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        Task savedTask = optionalTask.get();

        if (request.title() != null) {
            savedTask.setTitle(request.title());
        }
        if (request.description() != null) {
            savedTask.setDescription(request.description());
        }
        if (request.taskPriority() != null) {
            savedTask.setPriority(request.taskPriority());
        }
        if (request.taskStatus() != null) {
            savedTask.setStatus(request.taskStatus());
        }
        return taskMapper.toResponse(taskRepository.save(savedTask));
    }

    // ----------------------------------------------- Update Task Status ------------------------------------------
    // ----------------------------------------------- Partial Update --------------------------------------------
    public TaskResponse patchTaskStatus(UpdateTaskStatusRequest updateTaskRequest,
                                         String taskId) {
        Task savedTask = findTask(taskId);

        if (updateTaskRequest.taskStatus() != null) {
            savedTask.setStatus(updateTaskRequest.taskStatus());
        }

        return taskMapper.toResponse(taskRepository.save(savedTask));
    }

    // ----------------------------------------------- Delete Task Status ------------------------------------------
    public void deleteTask(String taskId) {
        Task task = findTask(taskId);
        taskRepository.delete(task);
    }

    private Task findTask(String taskId){
        return taskRepository.findByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }
}
