package com.subairdc.springboot.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.springboot.entity.Guardian;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
//	JSON Object
//	@Override
//	public String addStudent(String student) {
//		
//		JSONObject json = new JSONObject(student);
//
//		Student stu = Student.builder()
//				.emailId(json.getString("emailId"))
//				.firstName(json.getString("firstName"))
//				.lastName(json.getString("lastName"))
//				.build();
//		return null;
//	}
	
	@Override
	public Student addStudent(Student student) {
		
		JSONObject json = new JSONObject(student);
		
		Guardian guardian =Guardian.builder()
                .email(json.getJSONObject("guardian").getString("email"))
                .name(json.getJSONObject("guardian").getString("name"))
                .mobile(json.getJSONObject("guardian").getString("mobile"))
                .build();

		Student stu = Student.builder()
				.emailId(json.getString("emailId"))
				.firstName(json.getString("firstName"))
				.lastName(json.getString("lastName"))
				.guardian(guardian)
				.build();
		studentRepository.save(stu);
	
		return stu;
	}
	
	@Override
	public List<Student> addStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student updateStudent(Long id, Student student) {

		Student existingUser = studentRepository.findById(id).orElse(null);
	    if(existingUser == null) {	
//	    	System.out.println("Student not found");
	        return  null;
	     }else {
	    	 System.out.println(existingUser.toString());
	 		JSONObject json = new JSONObject(existingUser);

	 		Guardian guardian =Guardian.builder()
	 				.email(json.getJSONObject("guardian").getString("email"))
	                .name(json.getJSONObject("guardian").getString("name"))
	                .mobile(json.getJSONObject("guardian").getString("mobile"))
	                .build(); 
	 		
	    	 existingUser = Student.builder()
	 				.emailId(json.getString("emailId"))
	 				.firstName(json.getString("firstName"))
	 				.lastName(json.getString("lastName"))
	 				.guardian(guardian)
	 				.build();
	 		studentRepository.save(existingUser);
	     }
	    	 
	         return existingUser;
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student getStudentByFirstName(String name) {
		return studentRepository.findByFirstName(name).orElse(null);
	}

	@Override
	public Student getStudentByLastName(String name) {
		return studentRepository.findByLastName(name).orElse(null);
	}

	@Override
	public Student getStudentByEmailId(String emailId) {
		return studentRepository.findByEmailId(emailId).orElse(null);
	}

	@Override
	public boolean deleteStudentById(Long id) {
//		Optional<Student> existingUser = studentRepository.findById(id);
		if(studentRepository.findById(id) != null) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public String getStudentFirstNameByEmailAddress(String emailId) {
		
		return studentRepository.getStudentFirstNameByEmailAddress(emailId);
	}
//
//	@Override
//	public String getStudentCourse(Long id) {
//		
//		return studentRepository.getStudentCourse(id);
//	}
	
	
	
	
	
	
	
	
// 	For Test Cases
	
//	@Override
//	public Student addStudent(Student student) {
//		return studentRepository.save(student);
//	}
//
//	@Override	
//	public List<Student> addAllStudents(List<Student> students) {
//        return studentRepository.saveAll(students);
//    }
//
//	@Override
//	public Student getStudentById(Long id) {
//		return studentRepository.findById(id).orElse(null);
//	}
//
//	@Override
//	public List<Student> getStudentByFirstName(String name) {
//		return studentRepository.findByFirstName(name);
//	}
//
//	@Override
//	public List<Student> getStudentByLastName(String name) {
//		return studentRepository.findByLastName(name);
//	}
//	
//
//	@Override
//	public Student updateStudent(Long id, Student student) {
//		Student existingUser = studentRepository.findById(id).orElse(null);
//	    if(existingUser == null) {	
//	    	System.out.println("Student not found");
//	        return  null;
//	     }else {
//	    	 existingUser.setFirstName(student.getFirstName());
//	         existingUser.setLastName(student.getLastName());
//	         existingUser.setEmailId(student.getEmailId());
//	         studentRepository.save(existingUser);
//	         return existingUser;
//	      }
//	}
//
//	
//	@Override
//	public boolean deleteStudentById(Long id) {
//		Student existingUser = studentRepository.getById(id);
//        if(existingUser != null) {
//            studentRepository.deleteById(id);
//            return true;
//        }
//        return false;
//	}
//
//	@Override
//	public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//	}
//
//	@Override
//	public Student getStudentByEmailId(String emailId) {
//		return studentRepository.getStudentByEmailAddress(emailId);
//	}

}
