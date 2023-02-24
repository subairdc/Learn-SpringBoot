package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.Course;
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

//Associate Mapping
	
	Student addCourseToStudent(Long studentId, Long courseId);	

	
//For HQL	
	
	String getStudentFirstNameByEmailId(String emailId);

	List<Course> getCourseByStudentId(Long id);

	String getStuCourseDetailsByStudentId(Long id);

	List<Object[]> getCourseMaterialByStudentId(Long id);



	
	
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
