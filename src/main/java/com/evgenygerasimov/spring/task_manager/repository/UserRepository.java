package com.evgenygerasimov.spring.task_manager.repository;

import com.evgenygerasimov.spring.task_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
