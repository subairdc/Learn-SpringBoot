package com.subairdc.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.springboot.entity.CourseMaterial;
import com.subairdc.springboot.service.CourseMaterialService;

@RestController
@RequestMapping("/courseMaterial")
public class CourseMaterialController {
	
	@Autowired
	private CourseMaterialService courseMaterialService;

	@PostMapping("/addCourseMaterial") //Must add Course
	public CourseMaterial addCourseMaterial(@RequestBody CourseMaterial courseMaterial) {
		return courseMaterialService.addCourseMaterial(courseMaterial);
	} 
	
	@PostMapping("/addCourseMaterialWithCourse")
	public CourseMaterial addCourseMaterialWithCourse(@RequestBody CourseMaterial courseMaterial) {
		return courseMaterialService.addCourseMaterialWithCourse(courseMaterial);
	}
	
	@GetMapping("/getAllCourseMaterials")
	public List<CourseMaterial> getAllCourseMaterials() {
		return courseMaterialService.getAllCourseMaterials();
	}
	
//Associate Mapping
	@PostMapping("/addCourseMaterialExistingCourse/{courseId}") //Must add Course
	public CourseMaterial addCourseMaterialExistingCourse(@PathVariable Long courseId, @RequestBody CourseMaterial courseMaterial) {
		return courseMaterialService.addCourseMaterialExistingCourse(courseId, courseMaterial);
	} 
}
