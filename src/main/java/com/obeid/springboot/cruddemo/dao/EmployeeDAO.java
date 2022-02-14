package com.obeid.springboot.cruddemo.dao;

import java.util.List;

import com.obeid.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findall();

}
