package com.evgenygerasimov.spring.task_manager.service;

import com.evgenygerasimov.spring.task_manager.entity.Role;
import com.evgenygerasimov.spring.task_manager.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class RoleServiceTest {

    RoleRepository roleRepository = mock(RoleRepository.class);
    RoleService roleService = new RoleService(roleRepository);

    @Test
    void shouldSaveRoleTest() {
        //setup
        Role role = new Role();
        //execution
        roleService.save(role);
        //assertion
        verify(roleRepository).save(role);
    }
}