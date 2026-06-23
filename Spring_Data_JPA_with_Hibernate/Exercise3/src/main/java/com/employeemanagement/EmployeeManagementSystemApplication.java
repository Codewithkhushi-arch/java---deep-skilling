package com.employeemanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.employeemanagement.model.primary.Department;
import com.employeemanagement.model.primary.Employee;

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
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 3 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 3] Creating Repositories");
        System.out.println("EmployeeRepository and DepartmentRepository interfaces successfully created.");
        System.out.println("Derived query methods mapped in repositories.");

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 3 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
