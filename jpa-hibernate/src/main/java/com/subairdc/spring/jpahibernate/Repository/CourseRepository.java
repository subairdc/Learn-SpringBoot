package com.subairdc.spring.jpahibernate.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.spring.jpahibernate.entity.Course;
import com.subairdc.spring.jpahibernate.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//find by id
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	//Delete by id
	public void deleteById(Long id) {
		Course course = em.find(Course.class, id);
		em.remove(course); //need a Transaction
	}
	
	//update and insert
	
	public Course save(Course course) {
		if(course.getId() == null)
			em.persist(course);
		else 
			em.merge(course);
		return course;
			
	}
	
	public void playWithEntityManager() {
//		Course course1 = new Course("Master in Java");
//		em.persist(course1);
//		
//		Course course2 = findById(course1.getId());
//		
//		course2.setName("Master in Core Java - Updated");
		
		Course course1 = new Course("Master in Java");
		em.persist(course1);
		Course course2 = new Course("Master in Spring");
		em.persist(course2);
		
		em.flush(); // it will helps to store data to db
//		em.clear(); // after all courses are not updated
		
//		em.detach(course2); //course2 will not updated
		
		course1.setName("Master in Core Java - Updated");
		course2.setName("Master in SopringBoot - Updated");
		
		em.refresh(course1);// course will comes  back to the old value
		em.flush();
	}
	
	public void addTimeStamp() {
		
		Course course1 = new Course("Master in Java");
		em.persist(course1);
		em.flush();
		
		Course course2 = findById(course1.getId());
		
		course2.setName("Master in Core Java - Updated");
		
	}

	public void addHardcodedReviewsForcourse() { //hardcoded
		Course course = findById(10001L);
		logger.info("course.getREviews() -> {}",course.getReviews());
		
		Review review1 = new Review("5", "cool");
		Review review2 = new Review("4", "Hatsoff");
		
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);

		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsForcourse(Long courseId, List<Review> reviews) { //Generic method
		Course course = findById(courseId);
		logger.info("course.getREviews() -> {}",course.getReviews());
		
		for(Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
		
	}

}

