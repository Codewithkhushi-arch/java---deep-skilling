package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.Department;

@Repository
public class DepartmentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    private static List<Department> DEPARTMENT_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        LOGGER.info("START DepartmentDao Constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("departmentList", List.class);
        LOGGER.info("END DepartmentDao Constructor");
    }

    public List<Department> getAllDepartments() {
        LOGGER.info("START getAllDepartments");
        LOGGER.info("END getAllDepartments");
        return DEPARTMENT_LIST;
    }
}
