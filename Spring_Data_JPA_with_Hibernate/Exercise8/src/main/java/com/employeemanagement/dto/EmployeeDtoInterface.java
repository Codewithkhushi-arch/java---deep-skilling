package com.employeemanagement.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeDtoInterface {
    int getId();
    String getName();
    String getEmail();
    
    @Value("#{target.name + ' <' + target.email + '>'}")
    String getContactInfo();
}
