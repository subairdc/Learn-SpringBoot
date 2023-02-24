package com.subairdc.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Optional<Student> findByFirstName(String name);

	Optional<Student> findByLastName(String name);

	Optional<Student> findByEmailId(String emailId);

	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailId(String emailId);

	@Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
	List<Course> getCourseByStudentId(@Param("studentId") Long id);

	@Query("SELECT s.id, s.firstName, c.id, c.title FROM Student s JOIN s.courses c WHERE s.id = :studentId")
	String getStuCourseDetailsByStudentId(@Param("studentId") Long id);

    @Query("SELECT s.id, s.lastName, c.id, c.title, cm.url FROM Student s JOIN s.courses c JOIN c.courseMaterial cm WHERE s.id = :studentId")
    List<Object[]> getCourseMaterialByStudentId(@Param("studentId") Long id);
	
	
	
	
	
	
	
	
//	For Test cases
//	List<Student> findByFirstName(String name);
//
//	List<Student> findByLastName(String name);
//
//	Optional<Student> findByEmailId(String emailId);
//
//	List<Student> findByFirstNameContaining(String string);
//
//	List<Student> findByGuardianName(String string);
//	
//	
//	//JPQL
//    @Query("select s from Student s where s.emailId = ?1")
//    Student getStudentByEmailAddress(String emailId);
//
//    //JPQL
//    @Query("select s.firstName from Student s where s.emailId = ?1")
//    String getStudentFirstNameByEmailAddress(String emailId);
//
//    //Native
//    @Query(value = "SELECT * FROM tbl_student s where s.email_address = ?1",
//            nativeQuery = true
//    )
//    Student getStudentByEmailAddressNative(String emailId);
//
//
//    //Native Named Param
//    @Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
//            nativeQuery = true
//    )
//    Student getStudentByEmailAddressNativeNamedParam(
//            @Param("emailId") String emailId
//    );
//
//    @Modifying
//    @Transactional
//    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2",
//            nativeQuery = true
//    )
//    int updateStudentNameByEmailId(String firstName, String emailId);

}
