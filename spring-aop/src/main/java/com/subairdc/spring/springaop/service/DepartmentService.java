package com.subairdc.spring.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.spring.springaop.annotation.CustomAnnotation;
import com.subairdc.spring.springaop.model.Department;
import com.subairdc.spring.springaop.repository.DepartmentRepository;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment( Department department ){
        return departmentRepository.save(department);
    }

    @CustomAnnotation
    public Department getDepartmentById(Integer id ){
        return departmentRepository.findById(id).orElse(null);
    }
}