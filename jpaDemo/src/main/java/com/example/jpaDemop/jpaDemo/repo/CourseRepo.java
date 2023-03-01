package com.example.jpaDemop.jpaDemo.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpaDemop.jpaDemo.dao.Course;

public interface CourseRepo extends JpaRepository<Course,Integer>{

//	@Query("select c from Course c where c.courseId in (:list)")
	List<Course> findByCourseIdIn(List<Integer> list);

	
	@Query("select c from Course c where c.teacher.name=:name")
	Page<Course> findAllbyTeacherName(String name, Pageable p);


//	Page<Course> findAllbyName(String courseName, Pageable p);

}
