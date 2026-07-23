package com.employeemanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.employeemanagement.model.primary.Department;
import com.employeemanagement.repository.primary.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
