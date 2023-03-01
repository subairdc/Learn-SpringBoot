package com.example.jpaDemop.jpaDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaDemop.jpaDemo.dao.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
