package com.subairdc.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.CourseMaterial;
import com.subairdc.springboot.repository.CourseMaterialRepository;
import com.subairdc.springboot.repository.CourseRepository;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService{
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseMaterial addCourseMaterial(CourseMaterial courseMaterial) {
		
		if(courseMaterialRepository.save(courseMaterial) != null)
			return courseMaterial;
		else
			return null;
	}

	@Override
	public CourseMaterial addCourseMaterialWithCourse(CourseMaterial courseMaterial) {

		if(courseMaterialRepository.save(courseMaterial) != null)
			return courseMaterial;
		else
			return null;
	}

	@Override
	public List<CourseMaterial> getAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = 
			courseMaterialRepository.findAll();
			System.out.println("courseMaterials = " + courseMaterials);
		return courseMaterials;	
	}
	
//Associate Mapping

	@Override
	public CourseMaterial addCourseMaterialExistingCourse(Long courseId, CourseMaterial courseMaterial) {
		
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
		
		courseMaterialRepository.save(courseMaterial);
		courseMaterial.setCourse(course);

		courseRepository.save(course);
		
		return courseMaterial;
	}

}
