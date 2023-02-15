package com.subairdc.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.CourseMaterial.CourseMaterialBuilder;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	 Page<Course> findByTitleContaining(
	            String title,
	            Pageable pageable);
}
