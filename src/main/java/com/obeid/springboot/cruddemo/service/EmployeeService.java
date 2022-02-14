package com.obeid.springboot.cruddemo.service;

import java.util.List;

import com.obeid.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findall();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
