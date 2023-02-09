package com.subairdc.spring.jpahibernate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.spring.jpahibernate.Repository.StudentRepository;
import com.subairdc.spring.jpahibernate.entity.Course;
import com.subairdc.spring.jpahibernate.entity.Passport;
import com.subairdc.spring.jpahibernate.entity.Student;

import jakarta.persistence.EntityManager;

@SpringBootTest
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional //season management
	public void retriveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("Student -> {}", student);
		logger.info("Passport -> {}",student.getPassport()); // lazy fetch
	}
	
	@Test
	@Transactional //season management
	public void retrivePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 30001L);
		logger.info("Passport -> {}", passport);
		logger.info("Student -> {}",passport.getStudent()); // Bidirectional Way
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}
	
	//Season & SeasonFactory
	//EntityManager & Persistence
	//Transaction
	
	@Test
//	@Transactional //Persistence context
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext(); //studentRepository gives transactional
	}


//	private void someDummyOperation() {
//		//Database Operation 1 - Retrieve student
//		Student student = em.find(Student.class, 20001L);
//		//Persistence Context (student)
//		
//		//Database Operation 1 - Retrieve Passport
//		Passport passport = student.getPassport();
//		//Persistence Context (student, passport)
//		
//		//Database Operation 1 - Update Passport
//		passport.setNumber("P2401");
//		//Persistence Context (student, passport++)
//		
//		//Database Operation 1 - Update student
//		student.setName("Subair D");
//		//Persistence Context (student++, Passport++)
//	}
}
