package com.spring.app.service;

import com.spring.app.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee>getAllEmployees();

    List<Employee> findAll();
}
