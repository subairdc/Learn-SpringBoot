package com.example.jpaDemop.jpaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.dao.Student;
import com.example.jpaDemop.jpaDemo.service.StudentInter;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentInter StudentInter;
	
	@GetMapping("/getAllStudent")
	public String getAllstudent() {
		return StudentInter.getAllStudents();
	}
	
	@PostMapping("/saveStudents")
	public String saveStudents(@RequestBody String student) {
		return StudentInter.saveStudents(student);

	}
	
	@PutMapping("/saveStudents")
	public String saveStudents(int id) {
		return StudentInter.saveStudents(id);

	}

}
