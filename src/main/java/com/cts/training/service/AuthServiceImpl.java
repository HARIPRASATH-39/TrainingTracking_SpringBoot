package com.cts.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.cts.training.dto.LoginDTO;
import com.cts.training.entity.Employees;
import com.cts.training.repository.AuthRepository;

@Service

public class AuthServiceImpl implements AuthService {
	@Autowired
	AuthRepository authRepository;
	
	@Autowired
	PasswordEncoder passwordEncode;
	
//	@Autowired
//	JwtUtils jwtUtils;
	
	
//	@Override
//	public ResponseEntity<?> login(Employees employees) {
//		
//		Employees dbPerson = authRepository.findByEmployeeEmail(employees.getEmployeeEmail());
//
//		String password=dbPerson.getEmployeePassword();
//		
//		boolean loginStatus=passwordEncode.matches(employees.getEmployeePassword(),password);
//		
//		if(loginStatus)
//		{
////			String token = jwtUtils.generateToken(dbPerson);
//	
//			
//			LoginDTO loginDTO=new LoginDTO(dbPerson.getEmployeeId(), dbPerson.getEmployeeName(), ,dbPerson.getEmployeeGrade());
//			
//			return new ResponseEntity<LoginDTO>(loginDTO,HttpStatus.OK);
//
//		}
//		else { 
//			
//		
//			return new ResponseEntity<String>("Invalid Credentials",HttpStatus.NOT_ACCEPTABLE);
//		}
//		
//		
//	}

	@Override
	public ResponseEntity<?> register(Employees employees) {

		if(authRepository.findByEmployeeEmail(employees.getEmployeeEmail())!=null)
		{
			return new ResponseEntity<String>("ALREADY REGISTERED EMAIL",HttpStatus.NOT_ACCEPTABLE);
		}
		
		else if(authRepository.findByEmployeeId(employees.getEmployeeId())!=null)
		{
			return new ResponseEntity<String>("INVALID EMPLOYEE ID",HttpStatus.NOT_ACCEPTABLE);
			
		}
		
		employees.setEmployeePassword(passwordEncode.encode(employees.getEmployeePassword()));
		
		return  new ResponseEntity<Employees>(authRepository.save(employees),HttpStatus.OK);
	}
}
