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
import com.employeemanagement.service.DepartmentService;
import com.employeemanagement.service.EmployeeService;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
        LOGGER.info("EmployeeManagementSystem application started successfully.");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n=======================================================");
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 4 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 4] Implementing CRUD Operations");
        Department engineering = new Department();
        engineering.setName("Software Engineering");
        departmentService.saveDepartment(engineering);
        System.out.println("CRUD -> Saved Department: " + engineering.getName());

        Employee emp = new Employee();
        emp.setName("John Recruiter");
        emp.setEmail("john.recruiter@example.com");
        emp.setDepartment(engineering);
        employeeService.saveEmployee(emp);
        System.out.println("CRUD -> Saved Employee: " + emp.getName());

        Employee fetched = employeeService.getEmployeeById(emp.getId());
        System.out.println("CRUD -> Fetched Employee Name: " + fetched.getName());

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 4 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
