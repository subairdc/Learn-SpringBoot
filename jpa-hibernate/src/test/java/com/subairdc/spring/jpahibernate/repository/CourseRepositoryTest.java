package com.subairdc.spring.jpahibernate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.spring.jpahibernate.Repository.CourseRepository;
import com.subairdc.spring.jpahibernate.entity.Course;
import com.subairdc.spring.jpahibernate.entity.Review;
import com.subairdc.spring.jpahibernate.entity.Student;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;

@SpringBootTest
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Autowired
	EntityManager em;
	
	@Test
	public void findById_Basics() {
		
		Course course = repository.findById(10001L);
		assertThat("Java").isEqualTo(course.getName());
	}
	
//	@Test
//	@DirtiesContext //send the current data state
//	public void deleteById_Basics() {
//		repository.deleteById(10004L);
//		Course course = repository.findById(10004L);
//		assertThat(course).isEqualTo(null);
//		
//	}
	
	@Test
	public void save_Basics() {
		//get a course
		Course course = repository.findById(10002L);
		assertThat("Spring").isEqualTo(course.getName());
		
		//update cousre details
		course.setName("Spring MVC");
		repository.save(course);
		
		//check value
		Course course1 = repository.findById(10002L);
		assertThat("Spring MVC").isEqualTo(course.getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());//lazy fetching
	}

	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 40001L);
		logger.info("{}", review.getCourse());
	}
//
//	@Test
//	@Transactional
//	@DirtiesContext
//	public void performance() {
//		//for (int i = 0; i < 20; i++)
//			//em.persist(new Course("Something" + i));
//		//em.flush();
//		
//		//EntityGraph graph = em.getEntityGraph("graph.CourseAndStudents");
//		
//		EntityGraph<Course> graph = em.createEntityGraph(Course.class);
//	    Subgraph<List<Student>> bookSubGraph = graph.addSubgraph("students");
//	    
//	    List<Course> courses = em.createQuery("Select c from Course c", Course.class)
//	        .setHint("jakarta.persistence.loadgraph", graph)
//	        .getResultList();
//	    for (Course course : courses) {
//	      System.out.println(course + " " + course.getStudents());
//	    }
//	}
//
//	@Test
//	@Transactional
//	@DirtiesContext
//	public void performance_without_hint() {	    
//	    List<Course> courses = em.createQuery("Select c from Course c", Course.class)
//	        //.setHint("jakarta.persistence.loadgraph", graph)
//	        .getResultList();
//	    for (Course course : courses) {
//	      System.out.println(course + " " + course.getStudents());
//	    }
//	}


}
