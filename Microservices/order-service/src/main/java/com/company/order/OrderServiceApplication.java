package com.company.order;

import com.company.order.entity.Order;
import com.company.order.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(OrderRepository repository) {
        return args -> {
            repository.save(new Order(101L, 1L, "MacBook Pro", 2499.99));
            repository.save(new Order(102L, 2L, "iPhone 15", 999.99));
        };
    }
}
