/**
 * 
 */
package com.dev.frontend.services;

import java.util.List;

/**
 * @author bikash
 *
 */
public interface CRUDService<T> {
	
	String SERVER_URI = "http://localhost:8080/assignment";
	
	List<T> fetchAll();
	
	T fetchById(String id);
	
	T create(T entity);
	
	T update(T entity,String id);
	
	boolean delete(String id);
	

}
