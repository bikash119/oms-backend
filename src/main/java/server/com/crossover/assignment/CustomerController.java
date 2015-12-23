package com.crossover.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.service.url.CustomerRestURIConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	Map<Integer, Customer> empData = new HashMap<Integer, Customer>();
	@RequestMapping(value=CustomerRestURIConstants.CUSTOMER_DUMMY,method= RequestMethod.GET)
	public @ResponseBody Customer getDummyCustomer(){
		logger.info("Get dummy customer");
		Customer cust = new Customer();
		cust.setId(01);
		cust.setCurrentCredit(23.4f);
		cust.setName("Customer 1");
		cust.setPhoneNumber("+201011121314");
		return cust;
	}
	
	@RequestMapping(value=CustomerRestURIConstants.GET_CUSTOMER_BY_ID,method=RequestMethod.GET)
	public @ResponseBody Customer getCustomerById(@PathVariable("id") int custId){
		logger.info("get customer by id "+ custId);
		return null;
		
	}
	
	//TODO implement pagination
	@RequestMapping(value = CustomerRestURIConstants.GET_ALL_CUSTOMER,method=RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomers(){
		logger.info("get all customers");
		List<Customer> customers = new ArrayList<Customer>();
		Customer cust = new Customer();
		cust.setId(01);
		cust.setCurrentCredit(23.4f);
		cust.setName("Customer 1");
		cust.setPhoneNumber("+201011121314");
		customers.add(cust);
		return customers;
	}
	
	@RequestMapping(value=CustomerRestURIConstants.CREATE_CUSTOMER,method=RequestMethod.POST)
	public @ResponseBody Customer createCustomer(@RequestBody Customer customer){
		logger.info("create customer");
		return null;
	}
	
	@RequestMapping(value=CustomerRestURIConstants.UPDATE_CUSTOMER,method=RequestMethod.POST)
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer,@PathVariable("id") int id){
		logger.info("update customer : "+id);
		return null;
	}
	
}
