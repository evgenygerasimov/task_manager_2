package com.evgenygerasimov.spring.task_manager.service;

import com.evgenygerasimov.spring.task_manager.entity.User;
import com.evgenygerasimov.spring.task_manager.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class UserServiceTest {

    UserRepository userRepository = Mockito.mock(UserRepository.class);
    UserService userService = new UserService(userRepository);

    @Test
    void shouldSaveIfUserNotNullTest() {
        //setup
        User user = defaultUserCustomer();
        //execution
        userService.save(user);
        //assertion
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void shouldReturnListAllUsersTest() {
        //setup
        List<User> expectedUsersList = defaultUserList();
        Mockito.when(userRepository.findAll()).thenReturn(expectedUsersList);
        //execution
        List<User> actualUsersList = userService.findAll();
        //assertion
        Assertions.assertEquals(expectedUsersList, actualUsersList);
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnUserFindByUsernameTest() {
        //setup
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(defaultUserCustomer());
        //execution
        User user = userService.findByUsername("Ivan");
        //assertion
        Assertions.assertEquals(defaultUserCustomer().getUsername(), user.getUsername());
        Mockito.verify(userRepository, Mockito.times(1)).findByUsername(Mockito.anyString());
    }

    @Test
    void shouldGetListExecutorsTest() {
        //setup
        Mockito.when(userRepository.findAll()).thenReturn(defaultUserList());
        //execution
        List<User> executorsList = userService.getListExecutors();
        //assertion
        for (User user : executorsList) {
            Assertions.assertEquals("ROLE_EXECUTOR", user.getRole());
        }
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    //helpers methods
    private User defaultUserCustomer() {
        return new User(2, "Ivan", "password", 1, "ROLE_CUSTOMER", "email", "9832897328", new HashSet<>(), new HashMap<>());
    }

    private User defaultUserExecutor() {
        return new User(1, "Petr", "password", 1, "ROLE_EXECUTOR", "email", "827382738", new HashSet<>(), new HashMap<>());
    }

    private List<User> defaultUserList() {
        return List.of(defaultUserCustomer(), defaultUserExecutor());
    }
}