package com.crossover.assignment.dao;

import java.util.List;

import com.crossover.assignment.model.Product;


/**
 * @author bikash
 *
 */
public interface ProductDAO {

	public Product save(Product product);
	
	public List<Product> fetchAll();
	
	public Product fetchById(long id);
	
	public Product delete(String id);
	
	public Product update(String id,Product product);

}
