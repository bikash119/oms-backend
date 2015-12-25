/**
 * 
 */
package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.SalesOrder;
import com.crossover.assignment.service.url.SalesOrderRestURIConstants;

/**
 * @author bikash
 *
 */
public class SalesOrderCRUDService implements CRUDService<SalesOrder>{

	@Override
	public List<SalesOrder> fetchAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<SalesOrder> orders = new ArrayList<SalesOrder>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + SalesOrderRestURIConstants.GET_ALL_SALES,
				List.class);
		for (LinkedHashMap map : response) {
			SalesOrder order = new SalesOrder();
			order.setId(Long.parseLong(map.get("id").toString()));
			Object object = map.get("customer");
			order.setTotalPrice(Integer.parseInt(map.get("totalPrice").toString()));
			orders.add(order);
		}
		return orders;
	}

	@Override
	public SalesOrder fetchById(String id) {
		return null;
	}

	@Override
	public SalesOrder create(SalesOrder entity) {
		RestTemplate restTemplate = new RestTemplate();
		SalesOrder salesOrder = restTemplate.postForObject(SERVER_URI + SalesOrderRestURIConstants.CREATE_SALES,entity,
				SalesOrder.class);
		return salesOrder;
	}

	@Override
	public SalesOrder update(SalesOrder entity, String id) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
