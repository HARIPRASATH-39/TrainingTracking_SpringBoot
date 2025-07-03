package com.cts.training.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Courses {
	
	@Id
	private String courseId;
	
	private String courseDescription;
	
	private String courseName;
	
	private String courseLevel;
	
	private String courseDuration;
	
	private String courseLink;
	
	private LocalDateTime courseCreatedDate;

}
