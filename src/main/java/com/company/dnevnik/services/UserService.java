package com.company.dnevnik.services;

import com.company.dnevnik.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void saveUser(User user);

    void deleteUserById(Long id);
}
