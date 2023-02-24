package com.subairdc.spring.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.spring.springaop.model.Employee;
import com.subairdc.spring.springaop.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById( Integer id ){
        return employeeRepository.findById(id).orElseThrow();
    }
}
