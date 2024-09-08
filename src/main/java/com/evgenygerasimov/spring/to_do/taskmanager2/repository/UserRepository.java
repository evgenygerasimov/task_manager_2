package com.evgenygerasimov.spring.to_do.taskmanager2.repository;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
   public User findByUsername(String username);
}
