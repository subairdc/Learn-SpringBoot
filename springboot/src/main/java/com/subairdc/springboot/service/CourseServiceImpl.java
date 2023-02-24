package com.subairdc.springboot.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.CourseMaterial;
import com.subairdc.springboot.entity.Guardian;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.entity.Teacher;
import com.subairdc.springboot.repository.CourseRepository;
import com.subairdc.springboot.repository.StudentRepository;
import com.subairdc.springboot.repository.TeacherRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;


	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	@Override
	public List<Course> addCourses(List<Course> courses) {
		return courseRepository.saveAll(courses);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	@Override
	@Transactional
	public Course addCourseWithMaterial(Course course) {
		JSONObject json = new JSONObject(course);
		
		Course course2 = Course.builder()
				.title(json.getString("title"))
				.credit(json.getInt("credit"))
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url(json.getJSONObject("courseMaterial").getString("url"))
				.course(course2)
				.build();
			
		
		return courseRepository.save(course2);
	}
	
	@Override
	public Course addCourseWithStudent(Course course) {
		
		JSONObject json = new JSONObject(course);

		Guardian guardian =Guardian.builder()
			.email(json.getJSONArray("students").getJSONObject(0).getJSONObject("guardian").getString("email"))
			.name(json.getJSONArray("students").getJSONObject(0).getJSONObject("guardian").getString("name"))
			.mobile(json.getJSONArray("students").getJSONObject(0).getJSONObject("guardian").getString("mobile"))
			.build();

		Student stu = Student.builder()
			.emailId(json.getJSONArray("students").getJSONObject(0).getString("emailId"))
			.firstName(json.getJSONArray("students").getJSONObject(0).getString("firstName"))
			.lastName(json.getJSONArray("students").getJSONObject(0).getString("lastName"))
			.guardian(guardian)
			.build();
		
		Course cour = Course.builder()
				.title(json.getString("title"))
				.credit(json.getInt("credit"))
				.build();
		
//		studentRepository.save(stu);
	
		return courseRepository.save(course);
	}


	@Override
	public Course addCourseWithTeacher(Course course) {
		
//		if(courseRepository.save(course) != null)
//			return "add successful";
		return courseRepository.save(course);
	}

	@Override
	public Course addCourseWithStudentAndTeacher(Course course) {
//		if(courseRepository.save(course) != null)
//			return Course;
		return courseRepository.save(course);
	}

	@Override
	public Course addCourseWithStudentTeacherAndMaterial(Course course) {
		return  courseRepository.save(course);
	}
	
	//Associate Mapping

	@Override
	public Course addTeacherToCourse(Long courseId, Long teacherId) {
		Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

     Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

     course.setTeacher(teacher);

     Course savedCourse = courseRepository.save(course);
		return savedCourse;
	}
	

	

}
