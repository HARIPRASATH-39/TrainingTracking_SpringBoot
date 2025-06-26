package com.cts.training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Courses {
	
	@Id
	private int courseId;
	
	private String courseName;
	
	private String courseLevel;
	
	private String courseDuration;

}
