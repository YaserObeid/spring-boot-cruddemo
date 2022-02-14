package com.obeid.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeid.springboot.cruddemo.dao.EmployeeDAO;
import com.obeid.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return employeeDAO.findall();
	}
}
