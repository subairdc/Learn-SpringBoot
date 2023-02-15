package com.subairdc.springboot.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.springboot.entity.Guardian;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.entity.Teacher;
import com.subairdc.springboot.entity.Teacher;
import com.subairdc.springboot.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher addTeacher(Teacher teacher) {
//		if(teacherRepository.save(teacher) != null)
//			return "Add Teacher Succesfull";
//		else
//			return "Failed to Add Teacher";
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> addAllTeachers(List<Teacher> teachers) {
		if(teacherRepository.saveAll(teachers) != null)
			return teachers;
		else 
			return teachers;
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		
		Teacher existingTeacher = teacherRepository.findByTeacherId(id).orElse(null);
		
		existingTeacher.getCourses();
//		teacher.getCourses();
		
		return existingTeacher;
	}

	@Override
	public Teacher getTeacherByFirstName(String name) {
		return teacherRepository.findByFirstName(name).orElse(null);
	}

	@Override
	public Teacher getTeacherByLastName(String name) {
		return teacherRepository.findByLastName(name).orElse(null);
	}

	@Override
	public boolean deleteTeacherById(Long id) {
//		Optional<Teacher> existingUser = teacherRepository.findById(id);
		if(teacherRepository.findById(id) != null) {
			teacherRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Teacher updateTeacher(Long id, Teacher teacher) {
		
		Teacher existingUser = teacherRepository.findById(id).orElse(null);
	    if(existingUser == null) {	
	    	System.out.println("Teacher not found");
	        return  null;
	     }else {
	    	 
	 		JSONObject json = new JSONObject(existingUser); 
	 		
	    	 existingUser = Teacher.builder()
	 				.firstName(json.getString("firstName"))
	 				.lastName(json.getString("lastName"))
	 				.build();
	 		teacherRepository.save(existingUser);
	     }
		return existingUser;
	}
}
