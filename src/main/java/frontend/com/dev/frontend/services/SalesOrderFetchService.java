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
public class SalesOrderFetchService implements FetchService<SalesOrder>{

	@Override
	public List<SalesOrder> fetchAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<SalesOrder> orders = new ArrayList<SalesOrder>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + SalesOrderRestURIConstants.GET_ALL_SALES,
				List.class);
		for (LinkedHashMap map : response) {
			SalesOrder order = new SalesOrder();
			order.setId(map.get("id").toString());
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

}
