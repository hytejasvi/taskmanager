package com.learningSpringboot.taskmanager.controller;

import com.learningSpringboot.taskmanager.dto.CreateTaskDto;
import com.learningSpringboot.taskmanager.entities.TaskEntity;
import com.learningSpringboot.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") int id) {
        System.out.println("inside getTaskById");
        var task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println("task is not null");
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto createTaskDto) {
        return ResponseEntity.ok(taskService.addTask(
                createTaskDto.getTitle(), createTaskDto.getDescription(),
                createTaskDto.getDeadline()));
    }
}
