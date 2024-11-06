package com.evgenygerasimov.spring.task_manager.service;


import com.evgenygerasimov.spring.task_manager.repository.TaskRepository;
import com.evgenygerasimov.spring.task_manager.entity.Task;
import com.evgenygerasimov.spring.task_manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {

    private final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        logger.info("Finding all tasks");
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            logger.info("No tasks found");
        } else {
            logger.info("Found list with {} tasks found", tasks.size());
        }
        return tasks;
    }

    public List<Task> findAllByExecutor(User user) {
        logger.info("Finding all tasks by executor");
        List<Task> allTasks = getAllTasks();
        List<Task> filteredTasks = new ArrayList<>();
        if (user.getRole().equals("ROLE_EXECUTOR")) {
            for (Task task : allTasks) {
                if (task.getExecutor().equals(user.getUsername())) {
                    filteredTasks.add(task);
                }
            }
        }
        logger.info("Found list of tasks by executor with {} tasks found", filteredTasks.size());
        return filteredTasks;
    }

    public void addTask(Task task) {
        logger.info("Adding task");
        taskRepository.save(task);
        logger.info("Task with id {} added", task.getId());
    }

    public Task getTaskById(int id) {
        logger.info("Finding task by id {}", id);
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            logger.info("Task with id {} found", id);
            return task.get();
        } else {
            logger.info("Task with id {} not found", id);
            throw new NoSuchElementException();
        }
    }

    public void deleteTask(int id) {
        logger.info("Deleting task with id {}", id);
        taskRepository.deleteById(id);
        logger.info("Task with id{} deleted", id);
    }
}
