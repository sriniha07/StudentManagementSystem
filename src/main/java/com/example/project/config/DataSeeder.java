package com.example.project.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.project.entity.Department;
import com.example.project.entity.User;
import com.example.project.repository.DepartmentRepository;
import com.example.project.repository.UserRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(DepartmentRepository departmentRepository, UserRepository userRepository) {
        return args -> {
            if (departmentRepository.count() == 0) {
                Department cs = new Department();
                cs.setDepartmentName("Computer Science");
                cs.setHodName("Dr. Rao");
                cs.setDescription("Software engineering and algorithms");
                departmentRepository.save(cs);

                Department math = new Department();
                math.setDepartmentName("Mathematics");
                math.setHodName("Prof. Mehta");
                math.setDescription("Applied mathematics and statistics");
                departmentRepository.save(math);
            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@sms.com");
                admin.setPassword("admin123");
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}
