package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.Student;

public interface StudentService {
	
//	String addStudent(Student student);

	Student addStudent(Student student);

	List<Student> addAllStudents(List<Student> students);

	Student getStudentById(Long id);

	List<Student> getStudentByFirstName(String name);

	List<Student> getStudentByLastName(String name);
	
	Student updateStudent(Long id, Student student);

	boolean deleteStudentById(Long id);

	List<Student> getAllStudents();

	Student getStudentByEmailId(String emailId);


}
