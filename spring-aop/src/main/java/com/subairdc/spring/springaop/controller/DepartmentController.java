package com.subairdc.spring.springaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.spring.springaop.model.Department;
import com.subairdc.spring.springaop.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department addDepartment( @RequestBody Department department ){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getDepartmentById/{id}")
    public Department getDepartmentById( @PathVariable(value = "id") Integer id ){
        return departmentService.getDepartmentById(id);
    }
}