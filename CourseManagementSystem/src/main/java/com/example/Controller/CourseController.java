package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Course;
import com.example.Service.CourseService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<Course> AddCourse(@RequestBody Course course) {	
		try {
			courseService.AddCourse(course);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {	
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/course/{id}")
	public Course GetCourse(@PathVariable Long id){
		
			Course getcourse=courseService.GetCourseByID(id);
			return getcourse;
		
	}
	
	@GetMapping("/courses")
	public List<Course> GetAllCourses(){
		return courseService.GetAllCourses();
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> DeleteCourseByID(@PathVariable Long id){
		try {
			courseService.DeleteCourseByID(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
