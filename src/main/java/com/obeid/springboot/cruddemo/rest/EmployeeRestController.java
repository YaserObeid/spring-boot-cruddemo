package com.obeid.springboot.cruddemo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeid.springboot.cruddemo.entity.Employee;
import com.obeid.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return employeeService.findall();
	}
	
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
	
		Employee employee = employeeService.findById(id);
		
		if(employee == null)
			throw new RuntimeException(""
					+ "the employee: id="+ id+ " is not founs");
	
		return employeeService.findById(id);
	}
	
	@PostMapping("/employees")
	public Employee add(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if(employee == null)
			throw new RuntimeException(
					"the employee: id="+ id+ " is not founs");
		
		employeeService.deleteById(id);
		
		return "deleted the employee: id="+ id;
	}
}
