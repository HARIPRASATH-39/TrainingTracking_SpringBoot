package com.cts.training.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.training.dto.CourseDTO;
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
    public Courses getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> addCourse(Courses course) {
    	course.setCourseCreatedDate(LocalDateTime.now());
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCourse(String id, CourseDTO courseDto) {
        Courses dbCourse = courseRepository.findById(id).orElse(null);
        if (dbCourse != null) {
            if (courseDto.getCourseName() != null)
                dbCourse.setCourseName(courseDto.getCourseName());
            if (courseDto.getCourseDuration() != null)
                dbCourse.setCourseDuration(courseDto.getCourseDuration());
            if (courseDto.getCourseLevel() != null)
                dbCourse.setCourseLevel(courseDto.getCourseLevel());
            if(courseDto.getCourseDescription()!=null)
            	dbCourse.setCourseDescription(courseDto.getCourseDescription()); 
            if(courseDto.getCourseLink()!=null)
            	dbCourse.setCourseLink(courseDto.getCourseLink());
            
            courseRepository.save(dbCourse);
            return new ResponseEntity<>(dbCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course ID not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteCourse(String id) {
        Courses course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course ID not found", HttpStatus.NOT_FOUND);
        }
    }
}
