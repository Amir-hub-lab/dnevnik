package com.company.dnevnik.bootstrap;

import com.company.dnevnik.entities.Role;
import com.company.dnevnik.repositories.RoleRepository;
import com.company.dnevnik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if (!roleRepository.findById(1L).isPresent()) {
            roleRepository.save(Role.builder().name("ROLE_PARENT").build());
        }
        if (!roleRepository.findById(2L).isPresent()) {
            roleRepository.save(Role.builder().name("ROLE_STUDENT").build());
        }
        if (!roleRepository.findById(3L).isPresent()) {
            roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
        }



    }
}
