package com.subairdc.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PostMapping("/addCourses")
	public List<Course> addCourses(@RequestBody List<Course> courses) {
		return courseService.addCourses(courses);
	}
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@PostMapping("/addCourseWithMaterial")
	public Course addCourseWithMaterial(@RequestBody Course course) {
		return courseService.addCourseWithMaterial(course);
	}
	
	@PostMapping("/addCourseWithStudent")
	public Course addCourseWithStudent(@RequestBody Course course) {
		return courseService.addCourseWithStudent(course);
	}
	
	@PostMapping("/addCourseWithTeacher")
	public Course addCourseWithTeacher(@RequestBody Course course) {
		return courseService.addCourseWithTeacher(course);
	}
	
	@PostMapping("/addCourseWithStudentAndTeacher")
	public Course addCourseWithStudentAndTeacher(@RequestBody Course course) {
		return courseService.addCourseWithStudentAndTeacher(course);
	}
	
	@PostMapping("/addCourseWithStudentTeacherAndMaterial")
	public Course addCourseWithStudentTeacherAndMaterial(@RequestBody Course course) {
		return courseService.addCourseWithStudentTeacherAndMaterial(course);
	}
	
	
	
}
