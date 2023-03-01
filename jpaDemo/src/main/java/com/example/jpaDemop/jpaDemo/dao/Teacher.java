package com.example.jpaDemop.jpaDemo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Column;

import lombok.Data;

@Entity
//@Data
@Table(name="tbl_teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer teacherId;
	@Column(name="teacher_name",nullable = false,length = 50)
	String name;
	@Column(name="teacher_age",length = 50)
	Integer age;
	
//	if ManyToOne see Course comment 
	
//	@OneToMany
//	@JoinColumn(name = "teacherId",referencedColumnName ="teacherId" )
//	List<Course> course;
	
	@OneToMany(mappedBy = "teacher")
	List<Course> course;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public Teacher(Integer teacherId, String name, Integer age, List<Course> course) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.age = age;
		this.course = course;
	}

	public Teacher() {
		super();
	}
	
	
	
	
}
