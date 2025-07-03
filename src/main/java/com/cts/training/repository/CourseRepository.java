package com.cts.training.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.entity.Courses;
import com.cts.training.entity.Trainings;

public interface CourseRepository extends JpaRepository<Courses, String> {


	
	

}
