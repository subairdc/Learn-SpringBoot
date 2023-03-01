package com.example.jpaDemop.jpaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.service.CourseInter;

@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseInter courseInter;

	@PostMapping("/courseHandle")
	public String addCourse(@RequestBody Course course) {
		return courseInter.saveCourse(course);

	}
	
	@GetMapping("/courseHandle")
	public String getCourse() {
		return courseInter.getAllCourse();

	}
	
	@GetMapping("/courseHandle/{name}")
	public String getCourseByTeacher(@PathVariable String name) {
		return courseInter.getCourseByTeacher(name);

	}
	
	@PutMapping("/courseHandle")
	public String associateTeacherWithCourse(@RequestBody String data) {
		return courseInter.associateTeacherWithCourse(data);

	}
	
	@PutMapping("/associateStudentWithCourse")
	public String associateStudentWithCourse(@RequestBody String data) {
		return courseInter.associateStudentWithCourse(data);

	}
	
	
//	@PostMapping("/courseHandle")
//	public String associateStrudentWithCourse(@RequestBody String data) {
//		return courseInter.associateStrudentWithCourse(data);
//
//	}

}
