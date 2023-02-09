package com.subairdc.springboot.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.springboot.entity.Guardian;
import com.subairdc.springboot.entity.Student;
import com.subairdc.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
//	JSON Object
//	@Override
	public String addStudentss(Student student) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject(student);

		Student stu = Student.builder().emailId(json.getString("firstName")).build();
		Guardian guardian =new Guardian();
		return null;
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override	
	public List<Student> addAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getStudentByFirstName(String name) {
		return studentRepository.findByFirstName(name);
	}

	@Override
	public List<Student> getStudentByLastName(String name) {
		return studentRepository.findByLastName(name);
	}
	

	@Override
	public Student updateStudent(Long id, Student student) {
		Student existingUser = studentRepository.findById(id).orElse(null);
	    if(existingUser == null) {	
	    	System.out.println("Student not found");
	        return  null;
	     }else {
	    	 existingUser.setFirstName(student.getFirstName());
	         existingUser.setLastName(student.getLastName());
	         existingUser.setEmailId(student.getEmailId());
	         studentRepository.save(existingUser);
	         return existingUser;
	      }
	}

	
	@Override
	public boolean deleteStudentById(Long id) {
		Student existingUser = studentRepository.getById(id);
        if(existingUser != null) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
	}

	@Override
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
	}

	@Override
	public Student getStudentByEmailId(String emailId) {
		return studentRepository.getStudentByEmailAddress(emailId);
	}

}
