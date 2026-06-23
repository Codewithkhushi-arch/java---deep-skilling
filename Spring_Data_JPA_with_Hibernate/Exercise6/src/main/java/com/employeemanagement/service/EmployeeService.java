package com.employeemanagement.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.employeemanagement.model.primary.Employee;
import com.employeemanagement.repository.primary.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return saved;
    }

    @Transactional
    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public List<Employee> findByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Transactional(readOnly = true)
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByDepartment(int deptId) {
        return employeeRepository.findEmployeesByDepartment(deptId);
    }

    @Transactional(readOnly = true)
    public Page<Employee> getEmployeesPagedAndSorted(String name, int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByNameContaining(name, pageable);
    }
}
