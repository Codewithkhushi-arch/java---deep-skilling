package com.employeemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 2 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 2] Creating JPA Entities");
        Department engineering = new Department();
        engineering.setName("Software Engineering");
        System.out.println("Created Department entity: " + engineering.getName());

        Employee emp1 = new Employee();
        emp1.setName("John Recruiter");
        emp1.setEmail("john.recruiter@example.com");
        emp1.setDepartment(engineering);
        System.out.println("Created Employee entity: " + emp1.getName());

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 2 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
