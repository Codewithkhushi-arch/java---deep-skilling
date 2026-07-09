package com.company.user;

import com.company.user.entity.User;
import com.company.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository repository) {
        return args -> {
            repository.save(new User(1L, "Alice Johnson", "alice@example.com"));
            repository.save(new User(2L, "Bob Smith", "bob@example.com"));
            repository.save(new User(3L, "Charlie Brown", "charlie@example.com"));
        };
    }
}
