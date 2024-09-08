package com.evgenygerasimov.spring.to_do.taskmanager2.repository;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
