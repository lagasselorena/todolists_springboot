package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task criar(Task task) {
        return repository.save(task);
    }

    public Task atualizar(Long id, Task taskAtualizada) {
        Task task = repository.findById(id).orElseThrow();

        task.setTitle(taskAtualizada.getTitle());
        task.setDescription(taskAtualizada.getDescription());
        task.setCompleted(taskAtualizada.isCompleted());
        task.setPriority(taskAtualizada.getPriority());

        return repository.save(task);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }
}