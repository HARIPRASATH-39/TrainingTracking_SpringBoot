package com.cts.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	
	private String courseId;
	
	private String courseDescription;
	
	private String courseName;
	
	private String courseLevel;
	
	private String courseDuration;
	
	private String courseLink;
	

}
