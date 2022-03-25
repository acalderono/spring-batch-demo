package com.ait.batch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.batch.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
