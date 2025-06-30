package com.cts.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Integer> {

	
	

}
