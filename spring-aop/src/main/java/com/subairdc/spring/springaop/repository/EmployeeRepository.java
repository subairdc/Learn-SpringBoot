package com.subairdc.spring.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subairdc.spring.springaop.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
}