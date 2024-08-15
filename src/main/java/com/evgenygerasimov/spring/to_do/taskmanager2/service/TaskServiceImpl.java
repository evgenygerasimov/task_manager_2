package com.evgenygerasimov.spring.to_do.taskmanager2.service;


import com.evgenygerasimov.spring.to_do.taskmanager2.dao.TaskRepository;
import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
