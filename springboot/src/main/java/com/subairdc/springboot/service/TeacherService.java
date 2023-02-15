package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.Teacher;
import com.subairdc.springboot.entity.Teacher;

public interface TeacherService {

	Teacher addTeacher(Teacher teacher);

	List<Teacher> addAllTeachers(List<Teacher> teachers);

	Teacher getTeacherById(Long id);

	List<Teacher> getAllTeachers();

	Teacher getTeacherByFirstName(String name);

	Teacher getTeacherByLastName(String name);

	boolean deleteTeacherById(Long id);

	Teacher updateTeacher(Long id, Teacher teacher);	

}
