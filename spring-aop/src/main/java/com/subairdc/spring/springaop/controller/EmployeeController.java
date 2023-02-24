package com.subairdc.spring.springaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.spring.springaop.model.Employee;
import com.subairdc.spring.springaop.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee ){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("getEmployeeById/{id}")
    public Employee getEmployeeById( @PathVariable(value = "id") Integer id ){
        return employeeService.getEmployeeById(id);
    }


}