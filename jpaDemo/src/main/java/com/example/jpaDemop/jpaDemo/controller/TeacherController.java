package com.example.jpaDemop.jpaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaDemop.jpaDemo.dao.Teacher;
import com.example.jpaDemop.jpaDemo.service.TeacherInter;

@RestController
@CrossOrigin("*")
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherInter teacherInter;

	@PostMapping("/teacherHandle")
	public String addCourse(@RequestBody Teacher teacher) {
		return teacherInter.saveCourse(teacher);

	}
	
	@GetMapping("/teacherHandle")
	public String getTeacher() {
		return teacherInter.getTeacher();

	}
}
