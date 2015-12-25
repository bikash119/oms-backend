/**
 * 
 */
package com.dev.frontend.services.operation;

import java.util.List;

import com.dev.frontend.services.operation.exception.CRUDServiceException;

/**
 * @author bikash
 *
 */
public interface CRUDService<T,E extends CRUDServiceException> {
	
	String SERVER_URI = "http://localhost:8080/assignment";
	
	List<T> fetchAll() throws E;
	
	T fetchById(String id) throws E;
	
	T create(T entity) throws E;
	
	T update(T entity,Long id) throws E;
	
	boolean delete(String id) throws E;
	

}
