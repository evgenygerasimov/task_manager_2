package com.evgenygerasimov.spring.task_manager.service;

import com.evgenygerasimov.spring.task_manager.repository.UserRepository;
import com.evgenygerasimov.spring.task_manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void save(User user) {
        logger.info("Saving user: {}", user.getUsername());
        userRepository.save(user);
        logger.info("User saved: {}", user.getUsername());
    }

    public List<User> findAll() {
        logger.info("Finding all users");
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            logger.info("No users found");
        } else {
            logger.info("Users found");
        }
        return users;
    }

    public User findByUsername(String username) {
        logger.info("Finding user with username: {}", username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.info("No user found with username: {}", username);
            return null;
        }
        logger.info("User found with username: {}", user.getUsername());
        return user;
    }

    public List<User> getListExecutors() {
        logger.info("Getting list executors");
        List<User> listAllUsers = userRepository.findAll();
        List<User> listExecutorUsers = new ArrayList<>();
        for (User user : listAllUsers) {
            if (user.getRole().equals("ROLE_EXECUTOR")) {
                listExecutorUsers.add(user);
            }
        }
        logger.info("Users found: {}", listExecutorUsers.size());
        return listExecutorUsers;
    }
}
