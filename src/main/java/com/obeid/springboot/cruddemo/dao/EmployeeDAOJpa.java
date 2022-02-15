package com.obeid.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obeid.springboot.cruddemo.entity.Employee;

/**
 * with JPA no creating sessions 
 */

@Repository
public class EmployeeDAOJpa implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findall() {
		
		// create query from (javax.persistence.Query)
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		
		// save or update 
		Employee dbEmployee = entityManager.merge(employee);
		//by adding will be new id generated 
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		
		entityManager.remove(
				entityManager.find(Employee.class, id)
				);
		// or using query:
//		Query query = entityManager.createQuery(
//				"delete from Employee where id=:theId");
//		query.setParameter("theId", id);

	}

}
