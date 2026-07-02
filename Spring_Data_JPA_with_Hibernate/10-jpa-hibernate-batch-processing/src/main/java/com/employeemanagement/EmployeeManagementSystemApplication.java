package com.employeemanagement;

import java.util.ArrayList;
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

@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class })
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
        System.out.println("  STARTING EMPLOYEE SYSTEM - EXERCISE 10 RUNNER    ");
        System.out.println("=======================================================\n");
        System.out.println("[Exercise 10] Hibernate Batch Processing");
        Department engineering = new Department();
        engineering.setName("Software Engineering");
        departmentService.saveDepartment(engineering);

        System.out.println("Inserting 5 employees in batch...");
        List<Employee> batchList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Employee batchEmp = new Employee();
            batchEmp.setName("BatchEmp " + i);
            batchEmp.setEmail("batch" + i + "@example.com");
            batchEmp.setDepartment(engineering);
            batchList.add(batchEmp);
        }
        employeeService.saveEmployeesBatch(batchList);
        System.out.println("Batch insert completed. Total employees in DB: " + employeeService.getAllEmployees().size());
        System.out.println("Secondary Database logs count after batch: " + employeeService.getAuditLogCount());

        System.out.println("\n=======================================================");
        System.out.println("  EXERCISE 10 RUN COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n");
    }
}
