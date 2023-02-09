package com.subairdc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subairdc.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
