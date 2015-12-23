package com.crossover.assignment.service.url;

/**
 * @author bikash
 *
 */
public interface ProductRestURIConstants {
	
	String PRODUCT_DUMMY = "/rest/product/dummy";
	String GET_PRODUCT_BY_ID = "/rest/product/{id}";
	String GET_ALL_PRODUCT = "/rest/products";
	String CREATE_PRODUCT = "/rest/product/create";
	String DELETLE_PRODUCT = "/rest/product/delete/{id}";
	String UPDATE_PRODUCT = "/rest/product/update/{id}";
	
}
