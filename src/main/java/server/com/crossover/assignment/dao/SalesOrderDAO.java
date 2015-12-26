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
	
	public SalesOrder fetchById(long id);
	
	public boolean delete(long id);
	
	public SalesOrder update(long id,SalesOrder salesOrder);

}
