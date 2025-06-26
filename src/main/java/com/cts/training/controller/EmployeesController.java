package com.cts.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.entity.Employees;
import com.cts.training.repository.EmployeeRepository;

@RestController
@RequestMapping("Employees")
public class EmployeesController {
	
	
	
	  @Autowired
	    private EmployeeRepository employeesRepository;

	    @GetMapping("/getAll")
		@PreAuthorize("hasAuthority('Associate')")
	    public List<Employees> getAllEmployees() {
	        return employeesRepository.findAll();
	    }

	
	
	
}
