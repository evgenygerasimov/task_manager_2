package com.evgenygerasimov.spring.to_do.taskmanager2.service;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import com.evgenygerasimov.spring.to_do.taskmanager2.repository.TaskRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findAllByExecutor(User user) {
        List<Task> allTasks= getAllTasks();
        List<Task> filteredTasks = new ArrayList<>();
        if (user.getRole().equals("ROLE_EXECUTOR")) {
            for (Task task : allTasks) {
                if (task.getExecutor().equals(user.getUsername())) {
                    filteredTasks.add(task);
                }
            }
        }
        return filteredTasks;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }


//    public void updateTask(Task task) {
//        taskRepository.save(task);
//    }


    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }


    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
