package com.example.Repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{

}
