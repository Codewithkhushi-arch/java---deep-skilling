package com.employeemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
        LOGGER.info("EmployeeManagementSystem application started successfully.");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n=======================================================");
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 1 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 1] Setup & Configuration Successful");
        System.out.println("H2 database configuration loaded correctly from application.properties.");

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 1 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
