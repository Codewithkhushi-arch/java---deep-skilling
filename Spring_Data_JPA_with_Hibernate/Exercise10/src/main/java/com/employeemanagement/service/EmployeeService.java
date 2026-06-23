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
import com.employeemanagement.dto.EmployeeDtoClass;
import com.employeemanagement.dto.EmployeeDtoInterface;
import com.employeemanagement.model.secondary.AuditLog;
import com.employeemanagement.repository.secondary.AuditLogRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AuditLogRepository auditLogRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AuditLogRepository auditLogRepository) {
        this.employeeRepository = employeeRepository;
        this.auditLogRepository = auditLogRepository;
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(transactionManager = "primaryTransactionManager")
    public Employee saveEmployee(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        
        AuditLog log = new AuditLog();
        log.setAction("SAVE_EMPLOYEE");
        log.setTimestamp(new Date());
        log.setDetails("Saved employee: " + saved.getName() + " with email: " + saved.getEmail());
        auditLogRepository.save(log);
        return saved;
    }

    @Transactional(transactionManager = "primaryTransactionManager")
    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.deleteById(id);
            
            AuditLog log = new AuditLog();
            log.setAction("DELETE_EMPLOYEE");
            log.setTimestamp(new Date());
            log.setDetails("Deleted employee with ID: " + id + ", Name: " + employee.getName());
            auditLogRepository.save(log);
        }
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public List<Employee> findByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public List<Employee> findEmployeesByDepartment(int deptId) {
        return employeeRepository.findEmployeesByDepartment(deptId);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public Page<Employee> getEmployeesPagedAndSorted(String name, int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByNameContaining(name, pageable);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public EmployeeDtoInterface findInterfaceProjectionById(int id) {
        return employeeRepository.findInterfaceProjectionById(id);
    }

    @Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
    public List<EmployeeDtoClass> findClassProjectionsByName(String name) {
        return employeeRepository.findClassProjectionsByName(name);
    }

    @Transactional(transactionManager = "primaryTransactionManager")
    public List<Employee> saveEmployeesBatch(List<Employee> employees) {
        List<Employee> saved = employeeRepository.saveAll(employees);
        
        AuditLog log = new AuditLog();
        log.setAction("BATCH_SAVE_EMPLOYEES");
        log.setTimestamp(new Date());
        log.setDetails("Batch saved " + employees.size() + " employees");
        auditLogRepository.save(log);
        
        return saved;
    }

    @Transactional(transactionManager = "secondaryTransactionManager", readOnly = true)
    public long getAuditLogCount() {
        return auditLogRepository.count();
    }
}
