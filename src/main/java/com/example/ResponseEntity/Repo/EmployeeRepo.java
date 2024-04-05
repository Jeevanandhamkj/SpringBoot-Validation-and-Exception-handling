package com.example.ResponseEntity.Repo;

import com.example.ResponseEntity.mode.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
}
