package com.example.jpaDemop.jpaDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpaDemop.jpaDemo.dao.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	@Query("select c from Student c where c.studentId in (:studentlist)")
	List<Student> findByCourseIdIN(List<Integer> studentlist);

}
