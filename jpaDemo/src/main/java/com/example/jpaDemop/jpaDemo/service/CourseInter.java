package com.example.jpaDemop.jpaDemo.service;

import com.example.jpaDemop.jpaDemo.dao.Course;

public interface CourseInter {

	String saveCourse(Course course);

	String getAllCourse();

	String associateTeacherWithCourse(String data);

	String associateStudentWithCourse(String data);

	String getCourseByTeacher(String name);







}
