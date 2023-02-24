package com.subairdc.spring.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subairdc.spring.springaop.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	
}