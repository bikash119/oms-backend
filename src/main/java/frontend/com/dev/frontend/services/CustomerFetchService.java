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
public class CustomerFetchService implements FetchService<Customer> {

	@Override
	public List<Customer> fetchAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Customer> customers = new ArrayList<Customer>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + CustomerRestURIConstants.GET_ALL_CUSTOMER,
				List.class);
		for (LinkedHashMap map : response) {
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(map.get("id").toString()));
			customer.setCurrentCredit(Float.parseFloat((map.get("currentCredit").toString())));
			customer.setName(map.get("name").toString());
			customer.setPhoneNumber(map.get("phoneNumber").toString());
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public Customer fetchById(int id) {
		return null;
	}

}
