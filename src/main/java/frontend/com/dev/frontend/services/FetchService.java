/**
 * 
 */
package com.dev.frontend.services;

import java.util.List;

/**
 * @author bikash
 *
 */
public interface FetchService<T> {
	
	String SERVER_URI = "http://localhost:8080/assignment";
	
	List<T> fetchAll();
	
	T fetchById(String id);
	

}
