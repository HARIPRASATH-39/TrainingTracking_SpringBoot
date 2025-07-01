package com.cts.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.dto.TrainingDTO;
import com.cts.training.dto.TrainingStatusDTO;
import com.cts.training.entity.Trainings;
import com.cts.training.service.TrainingsService;

@RestController
@RequestMapping("/Trainings")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin

public class TrainingsController {
	
	
	    @Autowired
	    private TrainingsService trainingService;

	    @GetMapping("/getAll")
	    public List<Trainings> getAllTrainings() {
	        return trainingService.getAllTrainings();
	    }

	    @GetMapping("/getById/{id}")
	    public Trainings getTrainingById(@PathVariable int id) {
	        return trainingService.getTrainingById(id);
	    }

	    @PostMapping("/add")
		@PreAuthorize("hasAuthority('Associate')")
	    public ResponseEntity<?> addTraining(@RequestBody TrainingDTO training) {
	        return trainingService.addTraining(training);
	    }

	    @PutMapping("/update/{id}")
		@PreAuthorize("hasAuthority('Associate')")

	    public ResponseEntity<?> updateTraining(@PathVariable int id, @RequestBody Trainings training) {
	        return trainingService.updateTraining(id, training);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteTraining(@PathVariable int id) {
	        return trainingService.deleteTraining(id);
	    }
	    
	    @PutMapping("/trainingstatus/{id}")
		@PreAuthorize("hasAuthority('PAT')")

	    public String trainingStatus(@PathVariable int id, @RequestBody TrainingStatusDTO trainingStatusDTO) {
	    	
	    	return trainingService.trainingStatus(id,trainingStatusDTO);
	    }
	}