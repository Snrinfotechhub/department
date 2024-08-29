package com.snrinfotech.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.snrinfotech.department.entity.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
