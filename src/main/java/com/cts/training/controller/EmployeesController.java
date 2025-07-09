package com.cts.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.entity.Employees;
import com.cts.training.service.EmployeeService;

@RestController
@RequestMapping("Employees")
@CrossOrigin(origins = "http://localhost:5173") 

public class EmployeesController {
	
	@Autowired
	EmployeeService employeeService;

	
	    @GetMapping("/getAll")
		@PreAuthorize("hasRole('Associate')")
	    public List<Employees> getAllEmployees() {
	        return employeeService.getAllEmployee();
	    }
	    
	    @GetMapping("/getById/{id}")
		@PreAuthorize("hasRole('Associate')")
	    public Employees getEmployeeById(@PathVariable Long id) {
	    	
	    	return employeeService.getEmployeeById(id);
	    	
	    }
	    
	    @PutMapping("/update/{id}")
		public ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody Employees employee)
		{
			return employeeService.updateEmployee(id,employee);
		}
		

	
	
	
}
