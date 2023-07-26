package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee addEmployee(Employee employee);
	boolean removeEmployee(int id);
	String updateEmployee(Employee employee);
}
