package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@DeleteMapping("/remove/{id}")
	public boolean removeEmployee(@PathVariable(value =  "id") int id) {
		return employeeService.removeEmployee(id);
			
	}
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
			
	}
}
