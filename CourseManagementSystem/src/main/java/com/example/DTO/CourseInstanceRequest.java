package com.example.DTO;



import lombok.Data;

@Data
public class CourseInstanceRequest {
	
	private Long courseID;
	private int year;
	private int semester;
}
