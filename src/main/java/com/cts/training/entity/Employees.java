package com.cts.training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employees {

	@Id
	private Long employeeId;
	
	private String employeeName;
	
	private String employeeEmail;
	
	private String employeeGrade;
	
	private String employeePassword;
	
}
