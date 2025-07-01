package com.cts.training.dto;

import java.time.LocalDateTime;



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
