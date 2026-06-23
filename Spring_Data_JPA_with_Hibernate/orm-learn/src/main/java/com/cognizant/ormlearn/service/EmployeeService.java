package com.cognizant.ormlearn.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public Employee get(int id) {
        LOGGER.info("Get employee start");
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        if (employee.getSkillList() != null) {
            employee.getSkillList().size(); // Initialize lazy collection within transaction
        }
        return employee;
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Save employee start");
        employeeRepository.save(employee);
        LOGGER.info("Save employee end");
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Get permanent employees start");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int deptId) {
        LOGGER.info("Get average salary start");
        return employeeRepository.getAverageSalary(deptId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Get all employees native start");
        return employeeRepository.getAllEmployeesNative();
    }
}
