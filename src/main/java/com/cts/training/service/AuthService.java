package com.cts.training.service;

import org.springframework.http.ResponseEntity;

import com.cts.training.entity.Employees;


public interface AuthService {
//	ResponseEntity<?> login(Employees employees);

	ResponseEntity<?> register(Employees employees);
}
