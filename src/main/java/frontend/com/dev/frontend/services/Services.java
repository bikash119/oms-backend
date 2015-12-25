package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.model.Product;
import com.crossover.assignment.model.SalesOrder;
import com.dev.frontend.panels.ComboBoxItem;
import com.dev.frontend.services.operation.CRUDService;
import com.dev.frontend.services.operation.CustomerCRUDService;
import com.dev.frontend.services.operation.ProductCRUDService;
import com.dev.frontend.services.operation.SalesOrderCRUDService;
import com.dev.frontend.services.operation.exception.CustomerCRUDServiceException;
import com.dev.frontend.services.operation.exception.ProductCRUDServiceException;
import com.dev.frontend.services.operation.exception.SalesOrderCRUDServiceException;

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
		switch (objectType) {
		case 1:
			Product products = upsertProductRecords(object);
			break;
		case 2:
			Customer customers = upsertCustomerRecords(object);
			break;
		case 3:
			SalesOrder orders = upsertSalesOrderRecords(object);
			break;
		default:
			break;
		}
		return null;
	}

	private static SalesOrder upsertSalesOrderRecords(Object obj) {
		CRUDService<SalesOrder, SalesOrderCRUDServiceException> orderService = new SalesOrderCRUDService();
		SalesOrder salesOrder = (SalesOrder) obj;
		try {
			if (salesOrder.getId() != null) {
				orderService.update(salesOrder, salesOrder.getId());
			} else {
				salesOrder = orderService.create(salesOrder);
			}
		} catch (SalesOrderCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesOrder;
	}

	private static Customer upsertCustomerRecords(Object obj) {
		CRUDService<Customer, CustomerCRUDServiceException> customerService = new CustomerCRUDService();
		Customer customer = (Customer) obj;
		try {
			if (customer.getId() != null) {
				customer = customerService.update(customer, customer.getId());
			} else {
				customer = customerService.create(customer);
			}
		} catch (CustomerCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer;
	}

	private static Product upsertProductRecords(Object obj) {
		CRUDService<Product, ProductCRUDServiceException> productService = new ProductCRUDService();
		Product product = (Product) obj;
		try {
			if (product.getId() != null) {
				product = productService.update(product, product.getId());
			} else {
				product = productService.create(product);
			}
		} catch (ProductCRUDServiceException e) {
			e.printStackTrace();
		}
		return product;
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
		

		Object record = null;
		switch (objectType) {
		case 1:
			record = fetchProductRecordByProductId(code);
			break;
		case 2:
			record = fetchCustomerRecordByCustomerId(code);
			break;
		case 3:
			record = fetchSalesOrderRecordBySalesOrderId(code);
			break;
		default:
			break;
		}
		return record;
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
		CRUDService<Product,ProductCRUDServiceException> productFetchService = new ProductCRUDService();
		List<Product> products = null;
		try {
			products = productFetchService.fetchAll();
		} catch (ProductCRUDServiceException e) {
			e.printStackTrace();
		}
		return products;
	}

	private static List<Customer> fetchCustomerRecords() {
		CRUDService<Customer,CustomerCRUDServiceException> customerFetchService = new CustomerCRUDService();
		List<Customer> customers = null;
		try {
			customers = customerFetchService.fetchAll();
		} catch (CustomerCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	private static List<SalesOrder> fetchSalesOrderRecords() {
		CRUDService<SalesOrder,SalesOrderCRUDServiceException> salesOrderFetchService = new SalesOrderCRUDService();
		List<SalesOrder> salesOrders = null;
		try {
			salesOrders = salesOrderFetchService.fetchAll();
		} catch (SalesOrderCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesOrders;
	}
	
	private static Product fetchProductRecordByProductId(String productId) {
		CRUDService<Product,ProductCRUDServiceException> productFetchService = new ProductCRUDService();
		Product product = null;
		try {
			product = productFetchService.fetchById(productId);
		} catch (ProductCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	private static Customer fetchCustomerRecordByCustomerId(String customerId) {
		CRUDService<Customer,CustomerCRUDServiceException> customerFetchService = new CustomerCRUDService();
		Customer customer = null;
		try {
			customer = customerFetchService.fetchById(customerId);
		} catch (CustomerCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	private static SalesOrder fetchSalesOrderRecordBySalesOrderId(String salesOrderId) {
		CRUDService<SalesOrder,SalesOrderCRUDServiceException> salesOrderFetchService = new SalesOrderCRUDService();
		SalesOrder salesOrder = null;
		try {
			salesOrder = salesOrderFetchService.fetchById(salesOrderId);
		} catch (SalesOrderCRUDServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesOrder;
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		// TODO by the candidate
		/* Bikash :- IMPL done
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */
		

		List<ComboBoxItem> records = new ArrayList<ComboBoxItem>();
		switch (objectType) {
		case 1:
			List<Product> products = fetchProductRecords();
			for (Product product : products) {
				records.add(prepareComboBoxItem(product));
			}
			break;
		case 2:
			List<Customer> customers = fetchCustomerRecords();
			for (Customer customer : customers) {
				records.add(prepareComboBoxItem(customer));
			}
			break;
		default:
			break;
		}

		return records;
	}

	private static ComboBoxItem prepareComboBoxItem(Customer customer) {
		ComboBoxItem comboBoxItem = new ComboBoxItem();
		comboBoxItem.setKey(String.valueOf(customer.getId()));
		comboBoxItem.setValue(customer.getName());
		return comboBoxItem;
	}

	private static ComboBoxItem prepareComboBoxItem(Product product) {
		ComboBoxItem comboBoxItem = new ComboBoxItem();
		comboBoxItem.setKey(String.valueOf(product.getId()));
		comboBoxItem.setValue(product.getDesc());
		return comboBoxItem;
	}

	public static double getProductPrice(String productCode) {
		// TODO by the candidate
		/* Bikash :- IMPL done
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */
		Product productByCode = fetchProductByCode(productCode);
		if(productByCode != null){
			return productByCode.getPrice();
		}
		return 1;
	}

	private static Product fetchProductByCode(String productCode) {
		CRUDService<Product,ProductCRUDServiceException> productFetchService = new ProductCRUDService();
		Product product = null;
		try {
			product = productFetchService.fetchById(productCode);
		} catch (ProductCRUDServiceException e) {
			e.printStackTrace();
		}
		return product;
	}
}
