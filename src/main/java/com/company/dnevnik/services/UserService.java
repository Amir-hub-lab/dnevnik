package com.company.dnevnik.services;

import com.company.dnevnik.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void saveUser(User user);

    void deleteUserById(Long id);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
