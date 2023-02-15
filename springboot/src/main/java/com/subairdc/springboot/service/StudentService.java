package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.Student;

public interface StudentService {

	Student addStudent(Student student);
	
	List<Student> addStudents(List<Student> students);

	List<Student> getAllStudents();

	Student updateStudent(Long id, Student student);

	Student getStudentById(Long id);

	Student getStudentByFirstName(String name);

	Student getStudentByLastName(String name);

	Student getStudentByEmailId(String emailId);

	boolean deleteStudentById(Long id);

	String getStudentFirstNameByEmailAddress(String emailId);

//	String getStudentCourse(Long id);	


	
	
//For Test Cases	
	
//	Student addStudent(Student student);
//
//	List<Student> addAllStudents(List<Student> students);
//
//	Student getStudentById(Long id);
//
//	List<Student> getStudentByFirstName(String name);
//
//	List<Student> getStudentByLastName(String name);
//	
//	Student updateStudent(Long id, Student student);
//
//	boolean deleteStudentById(Long id);
//
//	List<Student> getAllStudents();
//
//	Student getStudentByEmailId(String emailId);


}
