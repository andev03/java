package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.EmployeeDao;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao employeeDao){
		return runner -> {
			// createEmployee(EmployeeDao);

			createMultipleEmployee(employeeDao);

			// readEmployee(employeeDao);

			// queryForEmployee(employeeDao);

			// queryForEmployeeByLastName(employeeDao);

            // deleteEmployee(employeeDao);
			
			 //deleteAllEmployee(employeeDao);
		};
	}

	private void createMultipleEmployee(EmployeeDao employeeDao) {
		// create the employee object
		System.out.println("Creating new employee object....");
		Employee tempEmployee = new Employee("Paul", "Doe", "paul@luv2code.com");
		Employee tempEmployee2 = new Employee("John", "Cena", "johncena@luv2code.com");
		Employee tempEmployee3 = new Employee("Kon", "Bangwa", "konbangwa@luv2code.com");
		// save the employee object
		System.out.println("Saving the employee...");
		employeeDao.save(tempEmployee);
		employeeDao.save(tempEmployee2);
		employeeDao.save(tempEmployee3);

		// display id of the saved employee

		System.out.println("Saved student. Generated id: " + tempEmployee.getId());
		System.out.println("Saved student. Generated id: " + tempEmployee2.getId());
		System.out.println("Saved student. Generated id: " + tempEmployee3.getId());
	}

	private void deleteAllEmployee(EmployeeDao employeeDao) {
		System.out.println("Delete all students");
		int numRowsDeleted = employeeDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}


	private void deleteEmployee(EmployeeDao employeeDao) {
        int employeeId = 3;

        System.out.println("Deleting student id: " + employeeId);
        employeeDao.deleteById(employeeId);
    }

    private void queryForEmployeeByLastName(EmployeeDao employeeDao) {
		List<Employee> theEmployees = employeeDao.findByLastName("Vega");
		for (Employee tempEmployee : theEmployees){
			System.out.println(tempEmployee);
		}
	}

	private void queryForStudent(EmployeeDao employeeDao) {
		List<Employee> theEmployees = employeeDao.findAll();
		for (Employee tempEmployee : theEmployees){
			System.out.println(tempEmployee);
		}
	}

	private void readEmployee(EmployeeDao employeeDao) {
		// create a employee object
		System.out.println("Creating employee...");
		Employee tempEmployee = new Employee("An", "Hoang", "hoangan@luv2code.com");
		// save the employee
		employeeDao.save(tempEmployee);
		// display id of the saved employee
		System.out.println("Id is: " + tempEmployee.getId());
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + tempEmployee.getId());
		Employee myEmployee = employeeDao.findById(tempEmployee.getId());
		// display employee
		System.out.println("Found the student: " + myEmployee);
	}

	private void createEmployee(EmployeeDao employeeDao) {
		// create the employee object
		System.out.println("Creating new employee object....");
		Employee tempEmployee = new Employee("Paul", "Doe", "paul@luv2code.com");
		// save the employee object
		System.out.println("Saving the employee...");
		employeeDao.save(tempEmployee);
		// display id of the saved employee

		System.out.println("Saved student. Generated id: " + tempEmployee.getId());
	}
}
