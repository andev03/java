package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {


    // define field for constructor
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the result

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return employee
        return theEmployee;
    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee by Id
        Employee theEmployee = entityManager.find(Employee.class, theId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found - " + theId);
        } else {
            // remove employee
            entityManager.remove(theEmployee);
        }
    }
}
