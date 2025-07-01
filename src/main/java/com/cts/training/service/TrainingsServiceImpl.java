package com.cts.training.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.training.dto.TrainingDTO;
import com.cts.training.dto.TrainingStatusDTO;
import com.cts.training.entity.Courses;
import com.cts.training.entity.Employees;
import com.cts.training.entity.Trainings;
import com.cts.training.repository.CourseRepository;
import com.cts.training.repository.EmployeeRepository;
import com.cts.training.repository.TrainingsRepository;

@Service
public class TrainingsServiceImpl implements TrainingsService {


    @Autowired
    private TrainingsRepository trainingRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    

    @Override
    public List<Trainings> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Trainings getTrainingById(int id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> addTraining(TrainingDTO trainingdto) {
    	
    	Trainings training= ConvertToTrainings(trainingdto);   	
        trainingRepository.save(training);
        return new ResponseEntity<>(training, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateTraining(int id, Trainings updated) {
        Trainings dbTraining = trainingRepository.findById(id).orElse(null);
        if (dbTraining != null) {
            if (updated.getAssignedTo() != null) dbTraining.setAssignedTo(updated.getAssignedTo());
            if (updated.getAssignedBy() != null) dbTraining.setAssignedBy(updated.getAssignedBy());
            if (updated.getCourse() != null) dbTraining.setCourse(updated.getCourse());
            if (updated.getStatus() != null) dbTraining.setStatus(updated.getStatus());
            if (updated.getFeedback() != null) dbTraining.setFeedback(updated.getFeedback());
            if (updated.getAssignedDate() != null) dbTraining.setAssignedDate(updated.getAssignedDate());
            if (updated.getCompletedDate() != null) dbTraining.setCompletedDate(updated.getCompletedDate());

            trainingRepository.save(dbTraining);
            return new ResponseEntity<>(dbTraining, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Training not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteTraining(int id) {
        Trainings training = trainingRepository.findById(id).orElse(null);
        if (training != null) {
            trainingRepository.delete(training);
            return new ResponseEntity<>("Training deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Training ID not found", HttpStatus.NOT_FOUND);
        }
    }
    
    public Trainings ConvertToTrainings(TrainingDTO trainingDTO)
    {
    	Employees assignedBy= employeeRepository.findByEmployeeId(trainingDTO.getAssignedBy());
    	
    	Employees assignedTo = employeeRepository.findByEmployeeId(trainingDTO.getAssignedTo());
    	
    	Courses course=courseRepository.findById(trainingDTO.getCourse()).get();
    	
    	Trainings trainings=Trainings.builder()
    			.assignedBy(assignedBy)
    			.assignedTo(assignedTo)
    			.course(course)
    			.status("Not Started")
    			.feedback(null)
    			.assignedDate(LocalDateTime.now())
    			.completedDate(null)
    			.build();
    	
    	return trainings;
    	
    }

	@Override
	public String trainingStatus(int id, TrainingStatusDTO trainingStatusDTO) {
		
		   Trainings dbTraining = trainingRepository.findById(id).orElse(null);
		   
		   dbTraining.setFeedback(trainingStatusDTO.getFeedback());
		   dbTraining.setStatus(trainingStatusDTO.getStatus());
		   if(trainingStatusDTO.getStatus()=="Completed")
		   {
			   dbTraining.setCompletedDate(LocalDateTime.now());
		   }
		
		return "Status Changed";
	}
    
    
    
    
}
