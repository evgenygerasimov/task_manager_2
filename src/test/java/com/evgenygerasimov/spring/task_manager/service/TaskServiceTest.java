package com.evgenygerasimov.spring.task_manager.service;

import com.evgenygerasimov.spring.task_manager.entity.Task;
import com.evgenygerasimov.spring.task_manager.entity.User;
import com.evgenygerasimov.spring.task_manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    TaskRepository taskRepository = mock(TaskRepository.class);
    TaskService taskService = new TaskService(taskRepository);

    @Test
    void shouldReturnAllTasksTest() {
        //setup
        List<Task> expectedTasks = defaultListTasks();
        when(taskRepository.findAll()).thenReturn(expectedTasks);
        //execution
        List<Task> actualTasks = taskService.getAllTasks();
        //assertion
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    void shouldReturnAllTasksByExecutorTest() {
        //setup
        List<Task> allTasks = defaultListTasks();
        for (Task task : allTasks) {
            task.setExecutor(defaultUserExecutor().getUsername());
        }
        for (Task task : defaultListTasks()) {
            task.setExecutor("Anna");
        }
        allTasks.addAll(defaultListTasks());
        when(taskRepository.findAll()).thenReturn(allTasks);
        //execution
        List<Task> executorTasks = taskService.findAllByExecutor(defaultUserExecutor());
        //assertion
        for (Task task : executorTasks) {
            assertEquals(defaultUserExecutor().getUsername(), task.getExecutor());
        }
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void shouldAddTaskTask() {
        //setup
        Task task = defaultTask();
        //execution
        taskService.addTask(task);
        //assertion
        assertNotNull(taskRepository.findById(task.getId()));
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldReturnTaskByIdTest() {
        //setup
        when(taskRepository.findById(anyInt())).thenReturn(Optional.of(defaultTask()));
        //execution
        Task task = taskService.getTaskById(1);
        //assertion
        assertEquals(defaultTask().getId(), task.getId());
        verify(taskRepository, times(1)).findById(anyInt());
    }

    @Test
    void shouldDeleteTask() {
        //setup
        Task task = defaultTask();
        //execution
        taskService.deleteTask(task.getId());
        //assertion
        verify(taskRepository, times(1)).deleteById(task.getId());
    }

    //helpers methods
    private List<Task> defaultListTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Task 1", "Task 1", "Done", "High", "Ivan", "Petr", "Comment", new User()));
        tasks.add(new Task(2, "Task 1", "Task 1", "Done", "High", "Ivan", "Petr", "Comment", new User()));
        tasks.add(new Task(3, "Task 1", "Task 1", "Done", "High", "Ivan", "Petr", "Comment", new User()));
        return tasks;
    }

    private User defaultUserExecutor() {
        User user = new User();
        user.setUsername("Petr");
        user.setPassword("Petr");
        user.setRole("ROLE_EXECUTOR");
        return user;
    }

    private Task defaultTask() {
        return new Task(1, "Task 1", "Task 1", "Done", "High", "Ivan", "Petr", "Comment", new User());
    }
}
