package com.employeemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
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
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 6 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 6] Implementing Pagination and Sorting");
        Department engineering = new Department();
        engineering.setName("Software Engineering");
        departmentService.saveDepartment(engineering);

        Employee emp1 = new Employee();
        emp1.setName("John Recruiter");
        emp1.setEmail("john.recruiter@example.com");
        emp1.setDepartment(engineering);
        employeeService.saveEmployee(emp1);

        Employee emp2 = new Employee();
        emp2.setName("Alice Evaluation");
        emp2.setEmail("alice.eval@example.com");
        emp2.setDepartment(engineering);
        employeeService.saveEmployee(emp2);

        System.out.println("Requesting paged employees (Page 0, Size 2, sorted by Name Ascending):");
        Page<Employee> pagedResult = employeeService.getEmployeesPagedAndSorted("", 0, 2, "name", "asc");
        System.out.println("  Total elements: " + pagedResult.getTotalElements());
        pagedResult.getContent().forEach(e -> System.out.println("  - Name: " + e.getName()));

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 6 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
