
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

import com.cts.training.dto.CourseDTO;
import com.cts.training.entity.Courses;
import com.cts.training.service.CourseService;

@RestController
@RequestMapping("Courses")
@CrossOrigin(origins = "http://localhost:5173") 

public class CourseController {

	@Autowired
	CourseService courseService;
	

    @GetMapping("/find/getAll")
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/find/getById/{id}")
    public Courses getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/add")
	@PreAuthorize("hasAuthority('Associate')")

    public ResponseEntity<?> addCourse(@RequestBody Courses course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/update/{id}")		
    @PreAuthorize("hasAuthority('Associate')")

    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('Associate')")

    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        return courseService.deleteCourse(id);
    }
	
	// TODO Add Course Link
    // TODO Change course Id
    // TODO ADD due Date in Course
    // TODO Add OAuth Server
    // TODO Add Due date in Training
    // TODO Course Created Date
    // TODO Create a separate for table
    
}
