package com.cts.training.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.training.entity.Employees;

public interface EmployeeService {

	List<Employees> getAllEmployee();

	Employees getEmployeeById(Long employeeId);

	ResponseEntity<?> updateEmployee(Long employeeId, Employees employee);

}
