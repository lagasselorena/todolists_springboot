package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.findAll();
    }

    @PostMapping
    public Task criar(@RequestBody Task task) {
        return taskService.criar(task);
    }

    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody Task taskAtualizada) {
        return taskService.atualizar(id, taskAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        taskService.deletar(id);
    }
}