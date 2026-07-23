package com.cognizant.springlearn;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
    @NotNull(message = "Employee ID cannot be null")
    private Integer id;

    @NotNull(message = "Employee Name cannot be null")
    @NotBlank(message = "Employee Name cannot be blank")
    @Size(min = 1, max = 30, message = "Employee Name must be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be zero or above")
    private Double salary;

    @NotNull(message = "Permanent status cannot be null")
    private Boolean permanent;

    @NotNull(message = "Date of birth cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+5:30")
    private Date dateOfBirth;

    @NotNull(message = "Department cannot be null")
    @Valid
    private Department department;

    @NotNull(message = "Skills list cannot be null")
    @Size(min = 1, message = "Employee must have at least one skill")
    @Valid
    private List<Skill> skills;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, Boolean permanent, Date dateOfBirth, Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.skills = skills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + skills + "]";
    }
}
