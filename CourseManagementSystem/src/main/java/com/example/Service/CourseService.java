package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Entity.Course;
import com.example.Repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public Course AddCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public List<Course> GetAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course GetCourseByID(Long id) {
		return courseRepository.findById(id).get();
	}
	
	public void DeleteCourseByID(Long id) {
		courseRepository.deleteById(id);
	}
}
