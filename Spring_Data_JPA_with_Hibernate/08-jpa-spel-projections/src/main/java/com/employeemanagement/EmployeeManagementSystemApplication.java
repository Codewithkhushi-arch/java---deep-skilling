package com.employeemanagement;

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
import com.employeemanagement.dto.EmployeeDtoClass;
import com.employeemanagement.dto.EmployeeDtoInterface;

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
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 8 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 8] Creating Projections");
        Department engineering = new Department();
        engineering.setName("Software Engineering");
        departmentService.saveDepartment(engineering);

        Employee emp = new Employee();
        emp.setName("John Recruiter");
        emp.setEmail("john.recruiter@example.com");
        emp.setDepartment(engineering);
        employeeService.saveEmployee(emp);

        System.out.println("Fetching Interface-based projection for Employee ID " + emp.getId() + ":");
        EmployeeDtoInterface interfaceProj = employeeService.findInterfaceProjectionById(emp.getId());
        if (interfaceProj != null) {
            System.out.println("  Id: " + interfaceProj.getId());
            System.out.println("  Name: " + interfaceProj.getName());
            System.out.println("  Dynamic SpEL Contact Info: " + interfaceProj.getContactInfo());
        }

        System.out.println("Fetching Class-based projections containing 'John':");
        List<EmployeeDtoClass> classProj = employeeService.findClassProjectionsByName("John");
        classProj.forEach(dto -> System.out.println("  DTO -> " + dto));

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 8 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
