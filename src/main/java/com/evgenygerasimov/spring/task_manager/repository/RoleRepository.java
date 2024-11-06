package com.evgenygerasimov.spring.task_manager.repository;


import com.evgenygerasimov.spring.task_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
