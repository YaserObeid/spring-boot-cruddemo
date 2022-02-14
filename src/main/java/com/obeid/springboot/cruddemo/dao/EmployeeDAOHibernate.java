package com.obeid.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obeid.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO {
	
	// define an EntityManager (bean is created by spring)
	// inject it
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findall() {
		
		// get the current (hibernamre) session using (EntityManager)
		
		Session session = entityManager.unwrap(Session.class);
		
		// create query from (org.hibernate.query.Query)
		Query<Employee> query = 
				session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		// save the given Employee
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(session.get(Employee.class, id));
		
//		Query theQuery = 
//				session.createQuery(
//						"delete from Employee where id=:employeeId");
//		theQuery.setParameter("employeeId", id);
//		
//		theQuery.executeUpdate();
		
	}

}
