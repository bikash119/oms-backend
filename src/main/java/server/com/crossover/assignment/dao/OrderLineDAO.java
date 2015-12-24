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
	
	public OrderLine delete(String id);
	
	public OrderLine update(String id,OrderLine orderLine);



}
