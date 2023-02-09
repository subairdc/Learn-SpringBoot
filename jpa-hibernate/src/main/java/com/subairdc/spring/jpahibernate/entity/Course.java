package com.subairdc.spring.jpahibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name="CourseTable")
//@NamedQuery(name= "query_get_all_courses",query="select c from course c")

@NamedQueries(value = {
		@NamedQuery(name= "query_get_all_courses",query="select c from Course c"),
		@NamedQuery(name= "query_get_namebased",query="select c from Course c where name like 'Java'")
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
//	@Column(name="fullname", nullable = false) //name can't be null value
	private String name;
	
//	@OneToMany(mappedBy = "course", fetch=FetchType.EAGER) //get the entire data form course (Review) 
	@OneToMany(mappedBy = "course") // default lazy fatch // ***ToMany : Default is Lazy Fatching
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")//student side is owning side
	private List<Student> students = new ArrayList<>();

	
	@CreationTimestamp
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	
	protected Course() {
		super();
	}


	public Course(String name) {
		super();
		this.name = name;
	}


	public Long getId() {
		return id;
	}


//	public void setId(Long id) {
//		this.id = id;
//	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}


	public List<Review> getReviews() {
		return reviews;
	}


//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}
	 public void addReview(Review review) {
		 this.reviews.add(review);
	 }
	
	 public void removeReview(Review review) {
		 this.reviews.remove(review);
	 }
	
	
}
