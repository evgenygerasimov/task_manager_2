package com.evgenygerasimov.spring.to_do.taskmanager2.service;



import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public void addTask(Task task);
    public Task getTaskById(int id);
    public void updateTask(Task task);
    public void deleteTask(int id);

}
