package com.subairdc.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.springboot.entity.Teacher;
import com.subairdc.springboot.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}
    
    // Add more than 1 teacher
	@PostMapping("/addTeachers")
	public List<Teacher> addAllTeachers(@RequestBody List<Teacher> teachers) {
		return teacherService.addAllTeachers(teachers);
	}
    
	//Get teacher by Id
	@GetMapping("/getTeacherById/{id}")
	public Teacher getTeacherById(@PathVariable Long id) {
		
//		Teacher teacher = teacherService.getTeacherById(id);
//		
//		teacher.getCourses();
		return teacherService.getTeacherById(id);
	}
	
    @GetMapping("/getAllTeachers")
	public List<Teacher> getAllteachers() {
		return teacherService.getAllTeachers();
	}
    
    @PutMapping("/updateTeacher/{id}")
    public Teacher upadteTeacher(@PathVariable Long id,@RequestBody Teacher teacher) {
    	return teacherService.updateTeacher(id,teacher);
    }
    
    //Get teacher by first name
    @GetMapping("/getTeacherByFirstName/{name}")
    public  Teacher getTeacherByFirstName(@PathVariable String name) {
    	return  teacherService.getTeacherByFirstName(name);
    }
  
    // Get teacher by last name
    @GetMapping("/getTeacherByLastName/{name}")
    public  Teacher getTeacherByLastName(@PathVariable String name) {
    	return  teacherService.getTeacherByLastName(name);
    }
    
    //Delete teacher
    @DeleteMapping("/deleteTeacherById/{id}")
	public boolean deleteTeacherById(@PathVariable Long id) {
	    return teacherService.deleteTeacherById(id);
	}
  
}
