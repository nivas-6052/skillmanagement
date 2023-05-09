package com.spring.app.service.impl;

import com.spring.app.Repository.EmployeeRepository;
import com.spring.app.model.Employee;
import com.spring.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
