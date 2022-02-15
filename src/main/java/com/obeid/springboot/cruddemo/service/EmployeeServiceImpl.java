package com.obeid.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obeid.springboot.cruddemo.dao.EmployeeRepository;
import com.obeid.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	/**
	 * since JpaRepository provides transaction functionality
	 * we should remove annotation: Transactional
	 */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findall() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		/**
		 * For findbyid, using this Optional approach
		 * this is introduced with the JpaRepository, part of Java 8
		 * more info at: luv2code.com/java-optional-tutorial
		 */
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		//if the found employee not null
		if(result.isPresent())
			employee = result.get();
		
		else 
			throw new RuntimeException("Employee ist not foun for id="+id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);

	}

}
