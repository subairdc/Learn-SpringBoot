package com.subairdc.springboot.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.CourseMaterial;
import com.subairdc.springboot.entity.Guardian;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.repository.CourseMaterialRepository;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService{
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

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

}
