package com.example.jpaDemop.jpaDemo.service;

import com.example.jpaDemop.jpaDemo.dao.Student;

public interface StudentInter {

	String getAllStudents();

	String saveStudents(String student);

	String saveStudents(int id);

}
