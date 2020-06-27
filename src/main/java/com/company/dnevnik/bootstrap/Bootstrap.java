package com.company.dnevnik.bootstrap;

import com.company.dnevnik.entities.User;
import com.company.dnevnik.entities.Role;
import com.company.dnevnik.repositories.UserRepository;
import com.company.dnevnik.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository userRolesRepository;

    @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                .login("admin")
                .password(passwordEncoder.encode("123"))
                .isActive(1)
                .build();

        User user = User.builder()
                .login("user")
                .password(passwordEncoder.encode("456"))
                .isActive(1)
                .build();
        Role adminRole = Role.builder()
                .roleName("ROLE_ADMIN")
                .user(admin)
                .build();

        Role userRole = Role.builder()
                .roleName("ROLE_USER")
                .user(user)
                .build();

        userRepository.save(admin);
        userRepository.save(user);

        userRolesRepository.save(adminRole);
        userRolesRepository.save(userRole);
    }


}