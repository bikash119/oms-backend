/**
 * 
 */
package com.crossover.assignment.dao;

import java.util.List;

import com.crossover.assignment.model.OrderLine;

/**
 * @author bikash
 *
 */
public interface OrderLineDAO {

	public OrderLine save(OrderLine orderLine);
	
	public List<OrderLine> fetchAll();
	
	public OrderLine fetchById(String id);
	
	public boolean delete(long id);
	
	public OrderLine update(long id,OrderLine orderLine);



}
