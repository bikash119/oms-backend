/**
 * 
 */
package com.dev.frontend.services.operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.service.url.CustomerRestURIConstants;
import com.dev.frontend.services.operation.exception.CustomerCRUDServiceException;

/**
 * @author bikash
 *
 */
public class CustomerCRUDService implements CRUDService<Customer,CustomerCRUDServiceException> {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerCRUDService.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Customer> fetchAll() throws CustomerCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		List<Customer> customers = new ArrayList<Customer>();
		
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + CustomerRestURIConstants.GET_ALL_CUSTOMER,
				List.class);
		for (LinkedHashMap map : response) {
			Customer customer = new Customer();
			customer.setId(Long.parseLong(map.get("id").toString()));
			customer.setCurrentCredit(Float.parseFloat((map.get("currentCredit").toString())));
			customer.setName(map.get("name").toString());
			customer.setPhoneNumber1(map.get("phoneNumber1").toString());
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public Customer fetchById(String id) throws CustomerCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(SERVER_URI + "/rest/customer/" + id, Customer.class);
		return customer;
	}

	@Override
	public Customer create(Customer entity) throws CustomerCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.postForObject(SERVER_URI + CustomerRestURIConstants.CREATE_CUSTOMER, entity,
				Customer.class);
		return customer;
	}

	@Override
	public Customer update(Customer entity, Long id) throws CustomerCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.postForObject(SERVER_URI+"/rest/customer/update/"+id, entity, Customer.class);
		return customer;
	}

	@Override
	public boolean delete(String id) throws CustomerCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		boolean isDeleted = true;
		try {
			restTemplate.delete(SERVER_URI+"/rest/customer/delete/"+id);
		} catch (RestClientException e) {
			isDeleted = false;
			throw new CustomerCRUDServiceException(e.getCause());
		}
		
		return isDeleted;
	}

}
