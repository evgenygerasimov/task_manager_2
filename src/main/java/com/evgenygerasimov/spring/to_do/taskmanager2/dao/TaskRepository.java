package com.evgenygerasimov.spring.to_do.taskmanager2.dao;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends JpaRepository<Task, Integer> {
}
