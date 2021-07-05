package com.albertviilik.todoapp.service;

import com.albertviilik.todoapp.model.Task;
import com.albertviilik.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.insert(task);
    }

    public void updateTask(Task task) {
        Task storedTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Task By ID %s", task.getId())));

        storedTask.setDescription(task.getDescription());
        storedTask.setCompleted(task.getCompleted());

        taskRepository.save(storedTask);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByDesc(String taskDescription) {
        return taskRepository.findByDescription(taskDescription)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Task By Name %s", taskDescription)));
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
