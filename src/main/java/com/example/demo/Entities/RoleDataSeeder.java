package com.example.demo.Entities;

import com.example.demo.repository.IRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RoleDataSeeder {
    private final IRoleRepository roleRepository;

    public RoleDataSeeder(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {

        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");

            Role userRole = new Role();
            userRole.setName("USER");
            
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
    }
}
