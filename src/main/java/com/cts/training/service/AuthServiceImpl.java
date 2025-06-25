package com.cts.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.training.entity.Employees;
import com.cts.training.repository.AuthRepository;

@Service

public class AuthServiceImpl implements AuthService {
	@Autowired
	AuthRepository authRepository;
	
	
	@Override
	public ResponseEntity<?> login(Employees employees) {
		 
		if(authRepository.findByEmployeeEmailAndEmployeePassword(employees.getEmployeeEmail(),employees.getEmployeePassword())!=null)
		{
			return new ResponseEntity<String>("LOGIN SUCCESSFUL",HttpStatus.OK);
		}
		return new ResponseEntity<String>("NO ACCOUNT FOUND",HttpStatus.UNAUTHORIZED);
		
	}

	@Override
	public ResponseEntity<?> register(Employees employees) {

		if(authRepository.findByEmployeeEmail(employees.getEmployeeEmail())!=null)
		{
			return new ResponseEntity<String>("ALREADY REGISTERED EMAIL",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return  new ResponseEntity<Employees>(authRepository.save(employees),HttpStatus.OK);
	}
}
