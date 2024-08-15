package com.evgenygerasimov.spring.to_do.taskmanager2.service;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;

public interface UserService {
    public void save(User user);
    public User getUserById(int id);

}
