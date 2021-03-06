/**
 * 
 */
package com.crossover.assignment.dao;

import java.util.List;

import com.crossover.assignment.model.Customer;

/**
 * @author bikash
 *
 */
public interface CustomerDAO {
	
	public Customer save(Customer customer);
	
	public List<Customer> fetchAll();
	
	public Customer fetchById(String id);
	
	public boolean delete(long id);
	
	public Customer update(long id,Customer customer);

}
