package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {


    List<Employee> findAll();
    
    Employee findById(int theId);

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);

}
