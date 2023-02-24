package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.Course;

public interface CourseService {

	Course addCourse(Course course);
	
	List<Course> addCourses(List<Course> course);

	List<Course> getAllCourses();
	
	Course addCourseWithMaterial(Course course);
	
	Course addCourseWithStudent(Course course);

	Course addCourseWithTeacher(Course course);
	
	Course addCourseWithStudentAndTeacher(Course course);
	
	Course addCourseWithStudentTeacherAndMaterial(Course course);
	
//Associate Mapping

	Course addTeacherToCourse(Long courseId, Long teacherId);


}
