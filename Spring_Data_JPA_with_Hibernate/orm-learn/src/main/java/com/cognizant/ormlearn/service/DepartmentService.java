package com.cognizant.ormlearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public Department get(int id) {
        LOGGER.info("Get department start");
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        if (department.getEmployeeList() != null) {
            department.getEmployeeList().size(); // Initialize lazy collection within transaction
        }
        return department;
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Save department start");
        departmentRepository.save(department);
        LOGGER.info("Save department end");
    }
}
