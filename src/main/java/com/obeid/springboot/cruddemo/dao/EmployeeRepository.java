package com.obeid.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

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


//to manually specify a plural name (endpoint-> localhost:8080/members) 
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's NO NEED to write any code :)

	/**
	 * Page Size:
	 * By default: Page Size=20 ->
	 * Spring Data REST will return the first 20 elements
	 * you can navigate to different pages of data using different query params
	 * localhost:8080/employees?page=0 -> first page
	 *  localhost:8080/employees?page=1 -> second page
	 *  
	 *  Spring Data REST has the following properties:
	 *  spring.data.rest.base-path=rest-api ->
	 *  localhost:8080/rest-api/employees
	 *  
	 *  spring.data.rest.default-page-size=30 ->
	 *  spring.data.rest.max-page-size=100 ->
	 *  by default is page size 20 you can modify it
	 *  so it's going to return 30 elements per page
	 *  
	 *  for more props search: spring.data.rest.* properties
	 *  
	 *  To sort by last name, and the ascending is the default:
	 *  ..../employees?sort=lastName
	 *  Sort by first name, descending:
	 *  ..../employees?sort=lastName,desc
	 *  Sort by first name and last name, descending:
	 *  ..../employees?sort=firstName,lastName,desc
	 */
}

