package com.example.jpaDemop.jpaDemo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.dao.CourseMaterial;
import com.example.jpaDemop.jpaDemo.repo.CourseMaterialRepo;
import com.example.jpaDemop.jpaDemo.repo.CourseRepo;

@Service
public class CourseMaterialImpl implements CourseMaterialInter{

	@Autowired
	CourseMaterialRepo courseMaterialRepo;
	@Autowired
	CourseRepo courseRepo;
	
	@Override
	public String saveCourseMaterial(JSONObject courseMaterial) {
		
		CourseMaterial cm= new CourseMaterial();
		
		Course course=courseRepo.findById(courseMaterial.getInt("courseId")).orElse(null);
		//course.setCourseName("AAAA");
		cm.setCourse(course);
		cm.setUrl(courseMaterial.getString("url"));
		courseMaterialRepo.save(cm);
		return "Success";
	}

	@Override
	public String getAllCourseMaterial() {

//		return courseMaterialRepo.findAll().toString();
	  	JSONArray ar= new JSONArray();
		List<CourseMaterial> l=courseMaterialRepo.findAll();
		l.stream().forEach((c)->{
			JSONObject json = new JSONObject();
			json.put("courseMaterialURL", c.getUrl());
			json.put("courseName", c.getCourse().getCourseName());
			json.put("TeacherName", c.getCourse().getTeacher().getName());
			ar.put(json);
		});
		return ar.toString();
		
	}
	

}
