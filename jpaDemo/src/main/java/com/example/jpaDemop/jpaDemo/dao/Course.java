package com.example.jpaDemop.jpaDemo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Data;

@Entity
//@Data
@Table(name = "tbl_course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Integer courseId;
	@Column(name = "course_name",length=50,nullable = false,unique = true)
	String courseName;
	
	@Column(name = "credit",length = 50)
	int credit;
	
//	cascade = CascadeType.ALL
	
	@OneToOne(mappedBy = "course")
	CourseMaterial courseMaterial;
	
	@ManyToOne()
	@JoinColumn(name = "teacherId",referencedColumnName = "teacherId")
	Teacher teacher;
	
	@ManyToMany()
	@JoinTable(
			name = "tbl_courseWithStudent",
			joinColumns = @JoinColumn(name="course_Id",referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(name="studentId",referencedColumnName = "studentId")
			)
	List<Student> student;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Course(Integer courseId, String courseName, int credit, CourseMaterial courseMaterial, Teacher teacher,
			List<Student> student) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.credit = credit;
		this.courseMaterial = courseMaterial;
		this.teacher = teacher;
		this.student = student;
	}

	public Course() {
		super();
	}
	
	
	
}
