package com.example.jpaDemop.jpaDemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.jpaDemop.jpaDemo.dao.Course;
import com.example.jpaDemop.jpaDemo.dao.Student;
import com.example.jpaDemop.jpaDemo.dao.Teacher;
import com.example.jpaDemop.jpaDemo.repo.CourseRepo;
import com.example.jpaDemop.jpaDemo.repo.StudentRepo;
import com.example.jpaDemop.jpaDemo.repo.TeacherRepo;

@Service
public class CourseImpl implements CourseInter {
	CourseRepo courseRepo;
	TeacherRepo teacherRepo;
	
	@Autowired
	StudentRepo StudentRepo;
	
	@Autowired
	public void setBeen(CourseRepo courseRepo,TeacherRepo teacherRepo) {
		this.courseRepo=courseRepo;
		this.teacherRepo = teacherRepo;
	}

	@Override
	public String saveCourse(Course course) {
		 courseRepo.save(course);
		 return"Success";
	}

	@Override
	public String getAllCourse() {
		String courseName="java";
		List<Course> courses=courseRepo.findAll();
		JSONArray jSONArray=new JSONArray();
		
		courses.stream().forEach(c->{
			JSONObject jSONObject= new JSONObject();
			jSONObject.put("CourseName", c.getCourseName());
			jSONObject.put("TeacherName", c.getTeacher().getName());
			jSONObject.put("CourseMaterialUrl", c.getCourseMaterial().getUrl());
			
			jSONArray.put(jSONObject);
		});
		
		return jSONArray.toString();
	}
	
	
	@Override
	public String getCourseByTeacher(String name) {
		Pageable p=PageRequest.of(0,10,Sort.by("courseName").descending()); 
		Page<Course> courses=courseRepo.findAllbyTeacherName(name,p);
		JSONArray jSONArray=new JSONArray();
		
		courses.stream().forEach(c->{
			JSONObject jSONObject= new JSONObject();
			jSONObject.put("CourseName", c.getCourseName());
			jSONObject.put("TeacherName", c.getTeacher().getName());
			jSONObject.put("CourseMaterialUrl", c.getCourseMaterial().getUrl());
			
			jSONArray.put(jSONObject);
		});
		
		return jSONArray.toString();
	}
	
	//ManyToOne Purpose

	@Override
	public String associateTeacherWithCourse(String data) {
		Iterable<Course> iterable=new ArrayList<>();
		JSONObject json= new JSONObject(data);
		List<Integer> list=Arrays.asList(json.getString("courseId").split(",")).stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
		List<Course> course=courseRepo.findByCourseIdIn(list);
		Optional<Teacher> teacher=	teacherRepo.findById(json.getInt("teacherId"));
		course.stream().forEach(c->{
			c.setTeacher(teacher.get());
			((ArrayList<Course>) iterable).add(c);
		});
		courseRepo.saveAll(iterable);
		
		return "success";
	}
	
	

	@Override
	public String associateStudentWithCourse(String data) {
		
		Iterable<Course> courses= new ArrayList<Course>();
		JSONObject json= new JSONObject(data);
		List<Integer> courselist=Arrays.asList(json.getString("courseId").split(",")).stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
		List<Integer> studentlist=Arrays.asList(json.getString("studentId").split(",")).stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
		List<Course> course=courseRepo.findByCourseIdIn(courselist);
		List<Student> student=StudentRepo.findByCourseIdIN(studentlist);
		course.stream().forEach(c->{
			c.setStudent(student);
			((ArrayList<Course>) courses).add(c);
		});
		courseRepo.saveAll(courses);
		return "success";
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//OneToMany PurPose 
//	@Override
//	public String associateTeacherWithCourse(String data) {
//		JSONObject json= new JSONObject(data);
//		Collection<Integer> list=Arrays.asList(json.getString("courseId").split(",")).stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
//		
//		
//		List<Course> course=courseRepo.findByCourseIdIN(list);
//	    Optional<Teacher> teacher=	teacherRepo.findById(json.getInt("teacherId"));
//	    
//	    teacher.get().setCourse(course);
//	    teacherRepo.save(teacher.get());
//		return "success";
//	}

}
