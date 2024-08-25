package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.CourseInstanceRequest;
import com.example.Entity.Course;
import com.example.Entity.CourseInstance;
import com.example.Repository.CourseInstanceRepository;
import com.example.Repository.CourseRepository;

@Service
public class CourseInstanceService {

	@Autowired
	private CourseInstanceRepository courseInstanceRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public CourseInstance AddCourseInstance(CourseInstanceRequest request) {
		  Optional<Course> courseOpt=courseRepository.findById(request.getCourseID());
		  CourseInstance instance = new CourseInstance();
		  Course course=courseOpt.get();
		  instance.setYear(request.getYear());
		  instance.setCourse(course);
		  instance.setSemester(request.getSemester());
		  
		  return courseInstanceRepository.save(instance);
	}
	
	public CourseInstance GetCourseInstance(int year,int semester,Long id) {
		return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, id);
	}
	
	public List<CourseInstance> GetCourseInstanceByYearandsemester(int year,int semester){
		return courseInstanceRepository.findByYearAndSemester(year, semester);
	}
	
	public void DeleteCourseInstance(int year,int semester,Long id) {
		CourseInstance courseInstance =courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, id);
		courseInstanceRepository.delete(courseInstance);
		
	}
	
	public void DeleteCourseInstanceById(Long id) {
		courseInstanceRepository.deleteById(id);
	}
	
	public List<CourseInstance> getAllInstances(){
		return courseInstanceRepository.findAll();
	}
	
	
}
