package com.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employeemanagement.model.primary.Employee;
import com.employeemanagement.service.EmployeeService;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee details) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employee.setName(details.getName());
        employee.setEmail(details.getEmail());
        if (details.getDepartment() != null) {
            employee.setDepartment(details.getDepartment());
        }
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Employee> findByName(@RequestParam String name) {
        return employeeService.findByNameContaining(name);
    }

    @GetMapping("/email")
    public ResponseEntity<Employee> findByEmail(@RequestParam String email) {
        Employee emp = employeeService.findByEmail(email);
        return emp != null ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartment(@PathVariable int deptId) {
        return employeeService.findEmployeesByDepartment(deptId);
    }

    @GetMapping("/search-paged")
    public Page<Employee> searchEmployeesPaged(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return employeeService.getEmployeesPagedAndSorted(name, page, size, sortBy, sortDir);
    }
}
