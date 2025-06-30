package com.cts.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

	Optional<Employees> findByEmployeeName(String username);

	Employees findByEmployeeId(Long employeeId);
	
	
	

}
