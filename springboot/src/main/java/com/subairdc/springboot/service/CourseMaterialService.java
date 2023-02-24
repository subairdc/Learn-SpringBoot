package com.subairdc.springboot.service;

import java.util.List;

import com.subairdc.springboot.entity.CourseMaterial;

public interface CourseMaterialService {

	CourseMaterial addCourseMaterial(CourseMaterial courseMaterial);

	CourseMaterial addCourseMaterialWithCourse(CourseMaterial courseMaterial);

	List<CourseMaterial> getAllCourseMaterials();

	CourseMaterial addCourseMaterialExistingCourse(Long courseId, CourseMaterial courseMaterial);

}
