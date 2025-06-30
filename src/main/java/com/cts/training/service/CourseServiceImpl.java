package com.cts.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.training.entity.Courses;
import com.cts.training.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
    CourseRepository courseRepository;

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> addCourse(Courses course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCourse(int id, Courses course) {
        Courses dbCourse = courseRepository.findById(id).orElse(null);
        if (dbCourse != null) {
            if (course.getCourseName() != null)
                dbCourse.setCourseName(course.getCourseName());
            if (course.getCourseDuration() != null)
                dbCourse.setCourseDuration(course.getCourseDuration());
            if (course.getCourseLevel() != null)
                dbCourse.setCourseLevel(course.getCourseLevel());
            courseRepository.save(dbCourse);
            return new ResponseEntity<>(dbCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course ID not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteCourse(int id) {
        Courses course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course ID not found", HttpStatus.NOT_FOUND);
        }
    }
}
