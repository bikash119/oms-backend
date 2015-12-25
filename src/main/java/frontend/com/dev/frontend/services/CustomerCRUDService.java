/**
 * 
 */
package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.service.url.CustomerRestURIConstants;

/**
 * @author bikash
 *
 */
public class CustomerCRUDService implements CRUDService<Customer> {

	@Override
	public List<Customer> fetchAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Customer> customers = new ArrayList<Customer>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + CustomerRestURIConstants.GET_ALL_CUSTOMER,
				List.class);
		for (LinkedHashMap map : response) {
			Customer customer = new Customer();
			customer.setId(Long.parseLong(map.get("id").toString()));
			customer.setCurrentCredit(Float.parseFloat((map.get("currentCredit").toString())));
			customer.setName(map.get("name").toString());
			customer.setPhoneNumber(map.get("phoneNumber").toString());
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public Customer fetchById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(SERVER_URI + "/rest/customer/"+id,
				Customer.class);
		return customer;
	}

	@Override
	public Customer create(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer entity, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
