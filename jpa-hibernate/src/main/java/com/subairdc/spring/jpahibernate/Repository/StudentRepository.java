package com.subairdc.spring.jpahibernate.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.spring.jpahibernate.entity.Course;
import com.subairdc.spring.jpahibernate.entity.Passport;
import com.subairdc.spring.jpahibernate.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	//find by id
	public Student findById(Long id) {
		return em.find(Student.class,id);
	}
	
	//Delete by id
	public void deleteById(Long id) {
		Student student = em.find(Student.class, id);
		em.remove(student); //need a Transaction
	}
	
	//update and insert
	public void saveStudentWithPassport() {
		Passport passport = new Passport("D5547");
		em.persist(passport);
		
		Student student = new Student("Messi");
		student.setPassport(passport);
		em.persist(student);
		
			
	}
	
	public void playWithEntityManager() {
//		Student student1 = new Student("Master in Java");
//		em.persist(student1);
//		
//		Student student2 = findById(student1.getId());
//		
//		student2.setName("Master in Core Java - Updated");
		
		Student student1 = new Student("Master in Java");
		em.persist(student1);
		Student student2 = new Student("Master in Spring");
		em.persist(student2);
		
		em.flush(); // it will helps to store data to db
//		em.clear(); // after all students are not updated
		
//		em.detach(student2); //student2 will not updated
		
		student1.setName("Master in Core Java - Updated");
		student2.setName("Master in SopringBoot - Updated");
		
		em.refresh(student1);// student will comes  back to the old value
		em.flush();
	}
	
	public void addTimeStamp() {
		
		Student student1 = new Student("Master in Java");
		em.persist(student1);
		em.flush();
		
		Student student2 = findById(student1.getId());
		
		student2.setName("Master in Core Java - Updated");
		
	}
	
	public void someOperationToUnderstandPersistenceContext() {
		//Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		//Persistence Context (student)
		
		//Database Operation 1 - Retrieve Passport
		Passport passport = student.getPassport();
		//Persistence Context (student, passport)
		
		//Database Operation 1 - Update Passport
		passport.setNumber("P2401");
		//Persistence Context (student, passport++)
		
		//Database Operation 1 - Update student
		student.setName("Subair D");
		//Persistence Context (student++, Passport++)
	}
	
	public void insertHardcodedStudentAndCourse(){
		Student student = new Student("Jack");
		Course course = new Course("Microservices");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student); //persist only owning side
	}

	public void insertStudentAndCourse(Student student, Course course){
		//Student student = new Student("Jack");
		//Course course = new Course("Microservices in 100 Steps");
		student.addCourse(course);
		course.addStudent(student);

		em.persist(student);
		em.persist(course);
	}

}

