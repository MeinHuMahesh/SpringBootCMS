package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Entity.CourseInstance;


public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
	public List<CourseInstance> findByYearAndSemester(int year, int semester);
    public CourseInstance findByYearAndSemesterAndCourseId(int year, int semester, Long id);
	
}
