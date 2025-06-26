package com.cts.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	
	
    private Long EmployeeId;
	
	private String employeeName;
	
	private String token;
	
	private String grade;
}
