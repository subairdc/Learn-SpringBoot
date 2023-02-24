package com.subairdc.springboot.controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	// Helloworld
    @GetMapping("/helloword")
    public String addStudent() {
        return "Hello World";
    }
 
    @PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
    
    // Add more than 1 student
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.addStudents(students);
	}
    
	//Get student by Id
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
    @GetMapping("/getAllStudents")
	public List<Student> getAllstudents() {
		return studentService.getAllStudents();
	}
    
    @PutMapping("/updateStudent/{id}")
    public Student upadteStudent(@PathVariable Long id,@RequestBody Student student) {
    	return studentService.updateStudent(id,student);
    }
    
    //Get student by first name
    @GetMapping("/getStudentByFirstName/{name}")
    public  Student getStudentByFirstName(@PathVariable String name) {
    	return  studentService.getStudentByFirstName(name);
    }
  
    // Get student by last name
    @GetMapping("/getStudentByLastName/{name}")
    public  Student getStudentByLastName(@PathVariable String name) {
    	return  studentService.getStudentByLastName(name);
    }
  
    // Get student by email Id
    @GetMapping("/getStudentByEmailId/{emailId}")
    public  Student getStudentByEmailId(@PathVariable String emailId) {
    	return  studentService.getStudentByEmailId(emailId);
    }
    
    //Delete student
    @DeleteMapping("/deleteStudentById/{id}")
	public boolean deleteStudentById(@PathVariable Long id) {
	    return studentService.deleteStudentById(id);
	}
    
//Associate Mapping
    @PutMapping("/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
    	return studentService.addCourseToStudent(studentId,courseId);
    }
    
    
//For HQL
    
 // Get student first name by email Id
    @GetMapping("/getStudentFirstNameByEmailId/{emailId}")
    public  String getStudentFirstNameByEmailId(@PathVariable String emailId) {
    	return  studentService.getStudentFirstNameByEmailId(emailId);
    }
    
  //Get Course by Student Id
  	@GetMapping("/getCourseByStudentId/{id}")
  	public List<Course> getCourseByStudentId(@PathVariable Long id) {
  		return studentService.getCourseByStudentId(id);
  	}
  	
  	 //Get Course Details by Student Id
  	@GetMapping("/getStuCourseDetailsByStudentId/{id}")
  	public String getStuCourseDetailsByStudentId(@PathVariable Long id) {
  		return studentService.getStuCourseDetailsByStudentId(id);
  	}
  	
  	 //Get Course Details by Student Id
  	@GetMapping("/getCourseMaterialByStudentId/{id}")
  	public List<Object[]> getCourseMaterialByStudentId(@PathVariable Long id) {
  		return studentService.getCourseMaterialByStudentId(id);
  	}
    
    
    
//	for test case
//	// Add new student
//    @PostMapping("/addStudent")
//    public Student addStudent(@RequestBody Student student) {
//        return studentService.addStudent(student);
//    }
//    
//    // Add more than 1 student
//    @PostMapping("/addStudents")
//    public List<Student> addAllStudents(@RequestBody List<Student> students) {
//        return studentService.addAllStudents(students);
//    }
//
//    // Get student by Id
//    @GetMapping("/getStudentById/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getStudentById(id);
//    }
//
//    // Get student by first name
//    @GetMapping("/getStudentByFirstName/{name}")
//    public  List<Student> getStudentByFirstName(@PathVariable String name) {
//        return  studentService.getStudentByFirstName(name);
//    }
//    
//    // Get student by last name
//    @GetMapping("/getStudentByLastName/{name}")
//    public  List<Student> getStudentByLastName(@PathVariable String name) {
//        return  studentService.getStudentByLastName(name);
//    }
//    
//    // Get student by email Id
//    @GetMapping("/getStudentByEmailId/{emailId}")
//    public  Student getStudentByEmailId(@PathVariable String emailId) {
//        return  studentService.getStudentByEmailId(emailId);
//    }
//    
//    // Update student
//    @PutMapping("/updateStudent/{id}")
//    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        return studentService.updateStudent(id,student);
//    }
//
//    // Delete student
//    @DeleteMapping("/deleteStudentById/{id}")
//    public boolean deleteStudentById(@PathVariable Long id) {
//        return studentService.deleteStudentById(id);
//    }
//
//    // Get all student
//    @GetMapping("/getAllStudents")
//    public List<Student> getAllStudents() {
//    	LOGGER.info("get Student Data");
//        return studentService.getAllStudents();
//    }
    
    
}
