package com.evgenygerasimov.spring.to_do.taskmanager2.service;

import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Role;
import com.evgenygerasimov.spring.to_do.taskmanager2.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public void save(Role role) {
        roleRepository.save(role);
    }
}
