package com.employeemanagement.repository.primary;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeemanagement.model.primary.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.employeemanagement.dto.EmployeeDtoClass;
import com.employeemanagement.dto.EmployeeDtoInterface;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByNameContaining(String name);

    Employee findByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
    List<Employee> findEmployeesByDepartment(@Param("deptId") int deptId);

    Page<Employee> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT e.id as id, e.name as name, e.email as email FROM Employee e WHERE e.id = :id")
    EmployeeDtoInterface findInterfaceProjectionById(@Param("id") int id);

    @Query("SELECT new com.employeemanagement.dto.EmployeeDtoClass(e.id, e.name, e.email) FROM Employee e WHERE e.name LIKE %:keyword%")
    List<EmployeeDtoClass> findClassProjectionsByName(@Param("keyword") String keyword);
}
