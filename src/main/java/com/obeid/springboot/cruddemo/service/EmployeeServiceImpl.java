package com.obeid.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obeid.springboot.cruddemo.dao.EmployeeDAO;
import com.obeid.springboot.cruddemo.entity.Employee;

	/**
	 * Standard JPA API:
	 * By having a standard API, you're not locked
	 * into a vendor's implementation
	 * So this allows you to maintain portable, flexible code.
	 * JPA also supports a query language: JPQL or the JPA Query language.
	 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	/**
	 * since we have 2  from EmployeeDAO
	 * we should add Qualifier
	 */
	@Autowired
	@Qualifier("employeeDAOJpa")
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findall() {
		
		return employeeDAO.findall();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDAO.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);

	}

}
