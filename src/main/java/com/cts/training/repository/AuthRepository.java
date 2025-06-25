package com.cts.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.entity.Employees;

public interface AuthRepository extends JpaRepository<Employees, Long> {

	Employees findByEmployeeEmail(String EmployeeEmail);

	Employees findByEmployeeEmailAndEmployeePassword(String EmployeeEmail, String EmployeePassword);
}
