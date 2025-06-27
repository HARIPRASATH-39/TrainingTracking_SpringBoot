package com.cts.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.cts.training.dto.LoginDTO;
import com.cts.training.entity.Employees;
import com.cts.training.repository.AuthRepository;
import com.cts.training.security.JwtUtils;

@Service

public class AuthServiceImpl implements AuthService {
	@Autowired
	AuthRepository authRepository;
	
	@Autowired
	PasswordEncoder passwordEncode;
	
	@Autowired
	JwtUtils jwtUtils;
	
	
	@Override
	public ResponseEntity<?> login(Employees employees) {
		 
//		if(authRepository.findByEmployeeEmailAndEmployeePassword(employees.getEmployeeEmail(),employees.getEmployeePassword())!=null)
//		{
//			return new ResponseEntity<String>("LOGIN SUCCESSFUL",HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("NO ACCOUNT FOUND",HttpStatus.UNAUTHORIZED);
		
		Employees dbPerson = authRepository.findByEmployeeEmail(employees.getEmployeeEmail());

		String password=dbPerson.getEmployeePassword();
		
		boolean loginStatus=passwordEncode.matches(employees.getEmployeePassword(),password);
		
		if(loginStatus)
		{
			String token = jwtUtils.generateToken(dbPerson);
	
			
			LoginDTO loginDTO=new LoginDTO(dbPerson.getEmployeeId(), dbPerson.getEmployeeName(), token,dbPerson.getEmployeeGrade());
			
			return new ResponseEntity<LoginDTO>(loginDTO,HttpStatus.OK);

		}
		else { 
			
		
			throw new RuntimeException("Invalid Credentials");
		
		}
		
		
	}

	@Override
	public ResponseEntity<?> register(Employees employees) {

		if(authRepository.findByEmployeeEmail(employees.getEmployeeEmail())!=null)
		{
			return new ResponseEntity<String>("ALREADY REGISTERED EMAIL",HttpStatus.NOT_ACCEPTABLE);
		}
		
		employees.setEmployeePassword(passwordEncode.encode(employees.getEmployeePassword()));
		
		return  new ResponseEntity<Employees>(authRepository.save(employees),HttpStatus.OK);
	}
}
