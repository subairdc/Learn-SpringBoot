package com.example.jpaDemop.jpaDemo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.dao.Teacher;
import com.example.jpaDemop.jpaDemo.repo.TeacherRepo;

@Service
public class TeacherImpl implements TeacherInter {

	@Autowired
	TeacherRepo teacherRepo;
	
	@Override
	public String saveCourse(Teacher teacher) {
		
		 teacherRepo.save(teacher);
		 return"Success";
	}

	@Override
	public String getTeacher() {
		
		List<Teacher> teachers= teacherRepo.findAll();
		JSONObject json= new JSONObject();
	
		teachers.stream().forEach(c->{
			JSONArray JSON=new JSONArray();
			List<Course> courses=c.getCourse();
			courses.stream().forEach(k->{
				JSONObject jSON= new JSONObject();
				jSON.put("courseName", k.getCourseName());
				jSON.put("courseUrl", k.getCourseMaterial().getUrl());
				JSON.put(jSON);
			});
			json.put(c.getName(), JSON);
		});
		
		return json.toString();
	}

}
