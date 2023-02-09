package com.subairdc.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retriveAllCourses() { //id name author
		return Arrays.asList(
				new Course(1, "JAVA", "James Gosling"),
				new Course(2, "Hibernate", "Gavin King"),
				new Course(3, "Spring", "Anees Jung"));
	}
}
