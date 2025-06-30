package com.cts.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.cts.training.entity.Employees;
import com.cts.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PasswordEncoder passwordEncode;
	
	@Override
	public List<Employees> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employees getEmployeeById(Long employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

	@Override
	public ResponseEntity<?> updateEmployee(Long employeeId, Employees employee) {
		
	Employees dbuser=employeeRepository.findByEmployeeId(employeeId);
	
	if(dbuser!=null)
	{
		if(employee.getEmployeeName()!=null)
		dbuser.setEmployeeName(employee.getEmployeeName());
		
		if(employee.getEmployeeEmail()!=null)
		dbuser.setEmployeeEmail(employee.getEmployeeEmail());
		
		if(employee.getEmployeePassword()!=null)
		dbuser.setEmployeePassword(passwordEncode.encode(employee.getEmployeePassword()));
		
		if(employee.getEmployeeGrade()!=null)
		dbuser.setEmployeeGrade(employee.getEmployeeGrade());
		
		employeeRepository.save(dbuser);
		
		return new ResponseEntity<Employees>(dbuser,HttpStatus.OK);

	}	
	
	else {
		
		return new ResponseEntity<String>("The ID is invalid",HttpStatus.NOT_FOUND);
	}
	
	
		
	
	}

}
