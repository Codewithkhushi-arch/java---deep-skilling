package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.Employee;

@Repository
public class EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("START EmployeeDao Constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", List.class);
        LOGGER.info("END EmployeeDao Constructor");
    }

    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees");
        LOGGER.info("END getAllEmployees");
        return EMPLOYEE_LIST;
    }
}
