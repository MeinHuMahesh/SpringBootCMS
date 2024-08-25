package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CourseInstanceRequest;
import com.example.Entity.CourseInstance;
import com.example.Service.CourseInstanceService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CourseInstanceController {
	@Autowired
	private CourseInstanceService courseInstanceService;
	
	@PostMapping("/instance")
	public CourseInstance AddCourseInstance(@RequestBody CourseInstanceRequest courseInstance){
		
			return courseInstanceService.AddCourseInstance(courseInstance);
			
		
		
	}
	
	@GetMapping("/instance/{year}/{semester}/{id}")
	public CourseInstance GetCourseInstance (@PathVariable int year,@PathVariable int semester,@PathVariable Long id){
		
			CourseInstance instance =  courseInstanceService.GetCourseInstance(year, semester, id);
			return(instance);
			
	}
	
	@DeleteMapping("/instance/{id}")
	public ResponseEntity<?>DeleteCourseInstanceById(@PathVariable Long id){
		try {
			courseInstanceService.DeleteCourseInstanceById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/instance/{year}/{semester}/{id}")
	public ResponseEntity<CourseInstance> DeleteCourseInstanceByYearAndSemester (@PathVariable int year,@PathVariable int semester,@PathVariable Long id){
		try {
			courseInstanceService.DeleteCourseInstance(year, semester, id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@GetMapping("/instance/{year}/{semester}")
	public List<CourseInstance> getCourseInstanceByYearAndSemester(@PathVariable int year,@PathVariable int semester){
		return courseInstanceService.GetCourseInstanceByYearandsemester(year, semester);
	}
	
	@GetMapping("/instances")
	public List<CourseInstance> AllCourseInstances(){
		return courseInstanceService.getAllInstances();
	}
	
	
}
