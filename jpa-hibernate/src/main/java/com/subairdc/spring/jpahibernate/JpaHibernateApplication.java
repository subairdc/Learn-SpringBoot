package com.subairdc.spring.jpahibernate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subairdc.spring.jpahibernate.Repository.CourseRepository;
import com.subairdc.spring.jpahibernate.Repository.EmployeeRepository;
import com.subairdc.spring.jpahibernate.Repository.StudentRepository;
import com.subairdc.spring.jpahibernate.entity.FullTimeEmployee;
import com.subairdc.spring.jpahibernate.entity.PartTimeEmployee;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
		
//		logger.info("Course 10001 ->{}", course);
		
//		courseRepository.deleteById(10004L);
//		courseRepository.save(new Course("Spring Boot"));
		
//		courseRepository.playWithEntityManager();
//		courseRepository.addTimeStamp();
		
//		studentRepository.saveStudentWithPassport();
		
//		courseRepository.addHardcodedReviewsForcourse();
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "cool"));
//		reviews.add(new Review("4", "Hatsoff"));
//		
//		courseRepository.addReviewsForcourse(10003L, reviews);	
		
//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertHardcodedStudentAndCourse();
//		 studentRepository.insertStudentAndCourse(new Student("Jack"),
//		 new Course("Microservices"));
		
		
		// Subair FullTimeEmployee salary - 10000$
		// Mohamed PartTimeEmployee - 50$ per hour
		
//		employeeRepository.insert(new PartTimeEmployee("Mohamed", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Subair", new BigDecimal("10000")));
		
//		logger.info("All Employees -> {}", 
//				employeeRepository.retrieveAllEmployees());

//		logger.info("Full Time Employees -> {}", 
//		employeeRepository.retrieveAllFullTimeEmployees());
//				
//		logger.info("Part Time Employees -> {}", 
//				employeeRepository.retrieveAllPartTimeEmployees());
	}

}
