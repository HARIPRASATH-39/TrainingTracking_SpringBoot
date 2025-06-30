package com.cts.training.dto;

import java.time.LocalDateTime;

import com.cts.training.entity.Courses;
import com.cts.training.entity.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
	
	
	
	    private Long assignedTo;
	    
	    private int course;
	    
	    private  Long assignedBy; 
	    
	    private String status;
	    
	    private String feedback;
	    
	    private LocalDateTime assignedDate;
	    
	    private LocalDateTime completedDate;

}
