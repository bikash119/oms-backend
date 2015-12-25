/**
 * 
 */
package com.crossover.assignment.dao;

import java.util.List;

import com.crossover.assignment.model.SalesOrder;


/**
 * @author bikash
 *
 */
public interface SalesOrderDAO {
	
	public SalesOrder save(SalesOrder salesOrder);
	
	public List<SalesOrder> fetchAll();
	
	public SalesOrder fetchById(String id);
	
	public boolean delete(String id);
	
	public SalesOrder update(String id,SalesOrder salesOrder);

}
