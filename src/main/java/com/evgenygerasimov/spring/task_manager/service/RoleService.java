package com.evgenygerasimov.spring.task_manager.service;

import com.evgenygerasimov.spring.task_manager.repository.RoleRepository;
import com.evgenygerasimov.spring.task_manager.entity.Role;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    public void save(Role role) {
        logger.info("Saving role: " + role);
        roleRepository.save(role);
        logger.info("Role saved: " + role);
    }
}
