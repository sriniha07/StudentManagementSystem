package com.example.project.service;

import com.example.project.entity.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
}
