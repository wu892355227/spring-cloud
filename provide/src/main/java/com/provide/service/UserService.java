package com.provide.service;

import com.provide.entity.User;

public interface UserService {
    public void addUser(User user);

    public User findById(Integer id);
}
