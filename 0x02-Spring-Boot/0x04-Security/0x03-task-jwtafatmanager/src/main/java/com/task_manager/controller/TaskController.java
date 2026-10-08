package com.task_manager.controller;

import com.task_manager.data.enums.TaskPriority;
import com.task_manager.data.enums.TaskStatus;
import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.TaskResponse;
import com.task_manager.dto.UpdateTaskRequest;
import com.task_manager.dto.UpdateTaskStatusRequest;
import com.task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks", produces = "application/json")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request){
        TaskResponse taskResponse = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping(path = "/{taskId}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable("taskId") String taskId){
        TaskResponse taskResponse = taskService.getTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> getAllTasks(@RequestParam(required = false) TaskStatus status,
                                                          @RequestParam(required = false) TaskPriority priority,
                                                          Pageable pageable) {
        return ResponseEntity.ok(taskService.getTasks(status, priority, pageable));
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskResponse> putTask(@Valid @RequestBody UpdateTaskRequest request,
                                                @PathVariable("taskId") String taskId){
        TaskResponse taskResponse = taskService.putTask(request, taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @PatchMapping(path = "/{taskId}")
    public ResponseEntity<TaskResponse> patchTask(@Valid @RequestBody UpdateTaskRequest request,
                                                  @PathVariable("taskId") String taskId){
        TaskResponse taskResponse = taskService.patchTask(request, taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @PatchMapping(path = "/{taskId}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(@Valid @RequestBody UpdateTaskStatusRequest request,
                                                         @PathVariable("taskId") String taskId){
        TaskResponse taskResponse = taskService.patchTaskStatus(request, taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @DeleteMapping(path = "/{taskId}")
    public void deleteTask(@PathVariable("taskId") String taskId){
        taskService.deleteTask(taskId);
    }
}
