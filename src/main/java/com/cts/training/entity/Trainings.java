package com.cts.training.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Trainings {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trainingId;
	 
	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employees assignedTo;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private Courses course;

	    @ManyToOne
	    @JoinColumn(name = "assigned_by_id")
	    private Employees assignedBy; 
	    
	    private String status;
	    
	    private String feedback;
	    
	    private LocalDateTime assignedDate;
	    
	    private LocalDateTime completedDate;
}
