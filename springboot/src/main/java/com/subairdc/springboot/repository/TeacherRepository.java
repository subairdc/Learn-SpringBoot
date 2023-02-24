package com.subairdc.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.subairdc.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	@Query("select t from Teacher t where t.lastName = ?1")
	Optional<Teacher> findByLastName(String name);

	@Query("select t from Teacher t where t.firstName = ?1")
	Optional<Teacher> findByFirstName(String name);

	@Query("select t from Teacher t where t.teacherId = ?1")
	Optional<Teacher> findByTeacherId(Long teacherId);

	@Query("SELECT t.id, t.firstName, c.id, c.title FROM Teacher t JOIN t.courses c WHERE t.id = :teacherId")
	String getCourseDetailsByTeacherId(@Param("teacherId") Long id);

    @Query("SELECT t.id, t.lastName, c.id, c.title, cm.url FROM Teacher t JOIN t.courses c JOIN c.courseMaterial cm WHERE t.id = :teacherId")
	List<Object[]> getCourseMaterialByTeacherId(@Param("teacherId") Long id);
	
}
