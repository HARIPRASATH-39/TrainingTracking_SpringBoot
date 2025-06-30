package com.cts.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.entity.Trainings;

public interface TrainingsRepository extends JpaRepository<Trainings, Integer> {

}
