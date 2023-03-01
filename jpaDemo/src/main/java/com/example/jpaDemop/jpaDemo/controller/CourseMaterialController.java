package com.example.jpaDemop.jpaDemo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaDemop.jpaDemo.service.CourseMaterialInter;

@RestController
@CrossOrigin("*")
@RequestMapping("/courseMaterial")
public class CourseMaterialController {

	@Autowired
	CourseMaterialInter courseMaterialInter;

	@PostMapping("/courseMaterialHandle")
	public String addCourse(@RequestBody String courseMaterial) {
		return courseMaterialInter.saveCourseMaterial(new JSONObject(courseMaterial));

	}
	
	@GetMapping("/courseMaterialHandle")
	public String getALLCourse() {
		return courseMaterialInter.getAllCourseMaterial();

	}
}
