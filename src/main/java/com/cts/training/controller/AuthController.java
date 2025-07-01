package com.cts.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.entity.Employees;
import com.cts.training.service.AuthService;



@RestController
@RequestMapping("Auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin

public class AuthController {


	
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Employees employees) {
		
		return authService.login(employees);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employees employees) {
		
		return authService.register(employees);
	}
}
	