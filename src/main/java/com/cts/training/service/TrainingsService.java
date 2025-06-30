package com.cts.training.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.training.dto.TrainingDTO;
import com.cts.training.entity.Trainings;

public interface TrainingsService {

	List<Trainings> getAllTrainings();

	Trainings getTrainingById(int id);

	ResponseEntity<?> addTraining(TrainingDTO training);

	ResponseEntity<?> updateTraining(int id, Trainings training);

	ResponseEntity<?> deleteTraining(int id);

}
