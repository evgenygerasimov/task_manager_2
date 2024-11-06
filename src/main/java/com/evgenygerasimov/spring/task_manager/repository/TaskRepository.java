package com.evgenygerasimov.spring.task_manager.repository;

import com.evgenygerasimov.spring.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByExecutor(String executor);
}
