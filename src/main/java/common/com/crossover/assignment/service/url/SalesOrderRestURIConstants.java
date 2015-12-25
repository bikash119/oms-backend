package com.crossover.assignment.service.url;

/**
 * @author bikash
 *
 */
public interface SalesOrderRestURIConstants {

	String SALES_DUMMY = "/rest/salesorder/dummy";
	String GET_SALES_BY_ID = "/rest/salesorder/{id}";
	String GET_ALL_SALES = "/rest/salesorders";
	String CREATE_SALES = "/rest/salesorder/create";
	String DELETLE_SALES = "/rest/salesorder/delete/{id}";
	String UPDATE_SALES = "/rest/salesorder/update/{id}";

}
