package com.crossover.assignment.service.url;

/**
 * @author bikash
 *
 */
public interface CustomerRestURIConstants {

	String CUSTOMER_DUMMY = "/rest/customer/dummy";
	String GET_CUSTOMER_BY_ID = "/rest/customer/{id}";
	String GET_ALL_CUSTOMER = "/rest/customers";
	String CREATE_CUSTOMER = "/rest/customer/create";
	String DELETLE_CUSTOMER = "/rest/customer/delete/{id}";
	String UPDATE_CUSTOMER = "/rest/customer/update/{id}";
	
}
