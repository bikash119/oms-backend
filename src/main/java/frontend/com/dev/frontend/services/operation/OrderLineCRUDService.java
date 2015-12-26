/**
 * 
 */
package com.dev.frontend.services.operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.OrderLine;
import com.crossover.assignment.service.url.OrderLineItemsRestURIConstants;
import com.crossover.assignment.service.url.ProductRestURIConstants;
import com.dev.frontend.services.operation.exception.OrderLineCRUDServiceException;

/**
 * @author bikash
 *
 */
public class OrderLineCRUDService implements CRUDService<OrderLine, OrderLineCRUDServiceException> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrderLine> fetchAll() throws OrderLineCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		List<OrderLine> orderLineItems = new ArrayList<OrderLine>();
		try {
			List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + ProductRestURIConstants.GET_ALL_PRODUCT,
					List.class);
			for (LinkedHashMap map : response) {
				OrderLine orderLine = new OrderLine();
				orderLine.setId(Long.parseLong(map.get("id").toString()));
				orderLine.setProductQuantity(Integer.parseInt(map.get("productQuantity").toString()));
				orderLine.setProductPrice(Float.parseFloat(map.get("price").toString()));
				orderLineItems.add(orderLine);
			}
		} catch (RestClientException e) {
			throw new OrderLineCRUDServiceException(e.getCause());
		}
		return orderLineItems;
	}

	@Override
	public OrderLine fetchById(String id) throws OrderLineCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		OrderLine product = null;
		try {
			product = restTemplate.getForObject(SERVER_URI + "/rest/orderLine/" + id, OrderLine.class);
		} catch (RestClientException e) {
			throw new OrderLineCRUDServiceException(e.getCause());
		}
		return product;
	}

	@Override
	public OrderLine create(OrderLine entity) throws OrderLineCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		OrderLine orderLine = null;
		try {
			orderLine = restTemplate.postForObject(SERVER_URI + OrderLineItemsRestURIConstants.CREATE_ORDERLINE, entity,
					OrderLine.class);
		} catch (RestClientException e) {
			throw new OrderLineCRUDServiceException(e.getCause());
		}
		return orderLine;
	}

	@Override
	public OrderLine update(OrderLine entity, Long id) throws OrderLineCRUDServiceException {
		return null;
	}

	@Override
	public boolean delete(String id) throws OrderLineCRUDServiceException {
		return false;
	}

}
