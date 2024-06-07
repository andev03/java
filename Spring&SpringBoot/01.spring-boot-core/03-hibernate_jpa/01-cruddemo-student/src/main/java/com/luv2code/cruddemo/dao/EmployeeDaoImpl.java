package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDelete = entityManager.createQuery("Delete From Employee").executeUpdate();
        return numRowsDelete;
    }
// define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee order by lastName asc", Employee.class);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String theLastName) {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee Where lastName=:theData", Employee.class);
        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // retrievie the employee
        Employee theEmployee = entityManager.find(Employee.class, id);

        // delete the employee
        entityManager.remove(theEmployee);
    }


}
