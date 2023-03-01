package com.example.jpaDemop.jpaDemo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import lombok.Data;

@Entity
//@Data
@Table(name = "tbl_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer studentId;
	@Column(name = "first_name", length = 50, nullable = false, unique = true)
	String firstName;
	@Column(name = "last_name", length = 50)
	String LastName;
	@Column(name = "email_id", length = 50, nullable = false, unique = true)
	String emailId;

	
//	@CreationTimestamp
	private Date created;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@PrePersist
	@Temporal(TemporalType.TIMESTAMP)
	protected void onCreate() {
		created = new Date();
	}

	//@PreUpdate
	//@Temporal(TemporalType.TIMESTAMP)
	protected void onUpdate() {
		updated = new Date();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Embedded
	@AttributeOverrides(
			{
			@AttributeOverride(name = "name", column = @Column(name = "gardian_name")),
			@AttributeOverride(name = "age", column = @Column(name = "gardian_age", length = 50)),
			@AttributeOverride(name = "relationShip", column = @Column(name = "gardian_relationShip", length = 50)) 
			}
	)
	Gardian gardian;
	
	@ManyToMany(mappedBy = "student")
	List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gardian getGardian() {
		return gardian;
	}

	public void setGardian(Gardian gardian) {
		this.gardian = gardian;
	}



	public Student(Integer studentId, String firstName, String lastName, String emailId, Date created, Date updated,
			Gardian gardian) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		LastName = lastName;
		this.emailId = emailId;
		this.created = created;
		this.updated = updated;
		this.gardian = gardian;
	}

	public Student() {
		super();
	}

}
