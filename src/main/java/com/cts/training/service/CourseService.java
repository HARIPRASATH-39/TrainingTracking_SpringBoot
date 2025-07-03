package com.cts.training.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.training.dto.CourseDTO;
import com.cts.training.entity.Courses;

public interface CourseService {

	List<Courses> getAllCourses();

	Courses getCourseById(String id);

	ResponseEntity<?> addCourse(Courses course);

	ResponseEntity<?> updateCourse(String id, CourseDTO courseDTO);

	ResponseEntity<?> deleteCourse(String id);

}
