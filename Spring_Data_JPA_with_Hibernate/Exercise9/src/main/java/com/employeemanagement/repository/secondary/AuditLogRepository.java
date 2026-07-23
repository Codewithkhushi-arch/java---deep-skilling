package com.employeemanagement.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeemanagement.model.secondary.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
}
