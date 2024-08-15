package com.evgenygerasimov.spring.to_do.taskmanager2.dao;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
