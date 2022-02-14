package com.obeid.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.obeid.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO {
	
	// define an EntityManager (bean is created by spring)
	// inject it
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Employee> findall() {
		
		// get the current (hibernamre) session using (EntityManager)
		
		Session qurrentsSssion = entityManager.unwrap(Session.class);
		
		// create query from (org.hibernate.query.Query)
		Query<Employee> query = 
				qurrentsSssion.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

}
