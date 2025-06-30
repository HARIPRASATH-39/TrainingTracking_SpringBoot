package com.cts.training.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.training.entity.Courses;

public interface CourseService {

	List<Courses> getAllCourses();

	Courses getCourseById(int id);

	ResponseEntity<?> addCourse(Courses course);

	ResponseEntity<?> updateCourse(int id, Courses course);

	ResponseEntity<?> deleteCourse(int id);

}
