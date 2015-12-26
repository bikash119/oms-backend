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
	
	public boolean delete(long id);
	
	public Product update(long id,Product product);

}
