package com.example.mongo_db_demo.service;

import com.example.mongo_db_demo.dto.EmployeeDTO;
import com.example.mongo_db_demo.model.Employee;
import com.example.mongo_db_demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee emp = Employee.builder()
                .empName(employeeDTO.getEmpName())
                .salary(employeeDTO.getSalary())
                .location(employeeDTO.getLocation())
                .build();
        employeeRepository.save(emp);
        return "Employee Created Successfully";
    }

    public List<Employee> getEmployeeAll() {

        return employeeRepository.findAll();
    }

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.findById(employeeDTO.getId()).isPresent()) {
            Employee employee = employeeRepository.findById(employeeDTO.getId()).get();
            employee.setEmpName(employeeDTO.getEmpName());
            employeeRepository.save(employee);
            return "Update successfully!";

        }

        return "Update failed!";
    }
}
