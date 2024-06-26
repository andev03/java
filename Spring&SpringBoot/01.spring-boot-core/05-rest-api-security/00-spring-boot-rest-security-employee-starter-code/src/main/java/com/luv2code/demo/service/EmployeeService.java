package com.luv2code.demo.service;

import com.luv2code.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);
}
