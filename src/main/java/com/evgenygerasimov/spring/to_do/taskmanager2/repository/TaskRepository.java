package com.evgenygerasimov.spring.to_do.taskmanager2.repository;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByExecutor(String executor);
}
