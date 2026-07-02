package com.cognizant.springlearn.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("Employees list size: {}", employees.size());
        LOGGER.info("END getAllEmployees");
        return employees;
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START updateEmployee: {}", employee.getId());
        employeeService.updateEmployee(employee);
        LOGGER.info("END updateEmployee");
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
        LOGGER.info("START deleteEmployee: {}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END deleteEmployee");
    }
}
