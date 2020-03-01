package com.abhay.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhay.demo.dao.EmployeeRepository;
import com.abhay.demo.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/test")
	public List<String> testEmployeeController() {
		List<String> successList = new ArrayList<String>(); 
		successList.add("SUCCESS");
		return successList;
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {		
		return employeeRepository.findAll();
	}
	
	@GetMapping("eid/{id}")
	public Employee getEmployeeById(@PathVariable("id")Integer id) {
		return employeeRepository.findById(id).orElse(new Employee());
	}
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
