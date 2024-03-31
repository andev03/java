package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee theEmployee);

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastName(String theLastName);

    void deleteById(Integer id);

    int deleteAll();
}
