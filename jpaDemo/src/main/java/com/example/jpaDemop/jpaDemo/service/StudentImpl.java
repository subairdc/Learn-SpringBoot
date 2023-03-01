package com.example.jpaDemop.jpaDemo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.dao.Gardian;
import com.example.jpaDemop.jpaDemo.dao.Student;
import com.example.jpaDemop.jpaDemo.dao.Teacher;
import com.example.jpaDemop.jpaDemo.repo.StudentRepo;

@Service
public class StudentImpl implements StudentInter {

	@Autowired
	StudentRepo StudentRepo;
	
	@Override
	public String getAllStudents() {
		//return StudentRepo.findAll().toString();
		
		List<Student> students= StudentRepo.findAll();
		JSONObject json= new JSONObject();
	
		students.stream().forEach(c->{
			JSONArray JSON=new JSONArray();
			List<Course> courses=c.getCourses();
			courses.stream().forEach(k->{
				JSONObject jSON= new JSONObject();
				jSON.put("courseName", k.getCourseName());
				jSON.put("courseUrl", k.getCourseMaterial().getUrl());
				JSON.put(jSON);
			});
			json.put(c.getFirstName(), JSON);
		});
		
		return json.toString();
	}

	@Override
	public String saveStudents(String student) {
		Student stu = new Student();
		Gardian gardian =new Gardian();
		JSONObject json = new JSONObject(student);
		stu.setFirstName(json.getString("firstName"));
		stu.setLastName(json.getString("LastName"));
		stu.setEmailId(json.getString("emailId"));
		gardian.setName(json.getString("name"));
		gardian.setRelationShip(json.getString("relationShip"));
		gardian.setAge(json.getInt("age"));
		stu.setGardian(gardian);
		
		StudentRepo.save(stu);
		return "success";
	}

	@Override
	public String saveStudents(int id) {
		Student stu=StudentRepo.findById(id).orElse(null);
		stu.setEmailId("shaheidali@gmail.com");
		StudentRepo.save(stu);
		return "success";
	}
	
}
