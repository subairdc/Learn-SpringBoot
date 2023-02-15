package com.subairdc.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.subairdc.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	@Query("select t from Teacher t where t.lastName = ?1")
	Optional<Teacher> findByLastName(String name);

	@Query("select t from Teacher t where t.firstName = ?1")
	Optional<Teacher> findByFirstName(String name);

//	@Query("select t from Teacher t where t.teacherId = ?1")
	Optional<Teacher> findByTeacherId(Long teacherId);
	
}
