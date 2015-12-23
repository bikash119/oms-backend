package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.model.Product;
import com.crossover.assignment.model.SalesOrder;
import com.dev.frontend.panels.ComboBoxItem;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	public static Object save(Object object, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called eventually after you click save on any edit
		 * screen object parameter is the return object from calling method
		 * guiToObject on edit screen and the type is identifier of the object
		 * type and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		return null;
	}

	public static Object readRecordByCode(String code, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you select record in list view of any
		 * entity and also called after you save a record to re-bind the record
		 * again the code parameter is the first column of the row you have
		 * selected and the type is identifier of the object type and may be
		 * TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		return null;
	}

	public static boolean deleteRecordByCode(String code, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order
		 * number of Sales Order and the type is identifier of the object type
		 * and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		return true;
	}

	public static List<Object> listCurrentRecords(int objectType) {
		List<Object> records = new ArrayList<Object>();
		switch (objectType) {
		case 1:
			List<Product> products = fetchProductRecords();
			for (Product product : products) {
				records.add(product);
			}
			break;
		case 2:
			List<Customer> customers = fetchCustomerRecords();
			for (Customer customer : customers) {
				records.add(customer);
			}
			break;
		case 3:
			List<SalesOrder> orders = fetchSalesOrderRecords();
			for (SalesOrder salesOrder : orders) {
				records.add(salesOrder);
			}
			break;
		default:
			break;
		}

		return records;
	}

	private static List<Product> fetchProductRecords() {
		FetchService<Product> productFetchService = new ProductFetchService();
		List<Product> products = productFetchService.fetchAll();
		return products;
	}

	private static List<Customer> fetchCustomerRecords() {
		FetchService<Customer> customerFetchService = new CustomerFetchService();
		List<Customer> customers = customerFetchService.fetchAll();
		return customers;
	}

	private static List<SalesOrder> fetchSalesOrderRecords() {
		FetchService<SalesOrder> salesOrderFetchService = new SalesOrderFetchService();
		List<SalesOrder> salesOrders = salesOrderFetchService.fetchAll();
		return salesOrders;
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */
		return new ArrayList<ComboBoxItem>();
	}

	public static double getProductPrice(String productCode) {
		// TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */
		return 1;
	}
}
