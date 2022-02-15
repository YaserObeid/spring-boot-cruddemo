package com.obeid.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obeid.springboot.cruddemo.entity.Employee;

	/**
	 * Spring Data JPA:
	 * you Create DAO and 
	 * just plug in your entity type and your primary key
	 * Spring will give you a CRUD implementation for free
	 * Spring Data provides an interface called: JpaRepository
	 * that it exposes full CRUD methods
	 * you get access to all of these CRUD methods
	 * without having to write any implementation code
	 * list of all these methods you can see at: 
	 *     luv2code.com/jpa-repository-javadoc
	 * 
	 * Spring Data JPA has some advanced features:
	 * Extend and add custom queries with JPQL
	 * Query domain specific language or a (query DSL)
	 * define custom methods (low level coding): 
	 * 		specifics, you're given business requirements.
	 * see more at:
	 * 		luv2code.com/spring-data-jpa-defining-custom-queties
	 * 
	 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's NO NEED to write any code :)

}

