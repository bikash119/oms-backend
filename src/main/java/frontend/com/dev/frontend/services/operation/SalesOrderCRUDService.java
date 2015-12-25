/**
 * 
 */
package com.dev.frontend.services.operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.SalesOrder;
import com.crossover.assignment.service.url.SalesOrderRestURIConstants;
import com.dev.frontend.services.operation.exception.SalesOrderCRUDServiceException;

/**
 * @author bikash
 *
 */
public class SalesOrderCRUDService implements CRUDService<SalesOrder,SalesOrderCRUDServiceException>{
	
	private static final Logger logger = LoggerFactory.getLogger(SalesOrderCRUDService.class);

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SalesOrder> fetchAll() throws SalesOrderCRUDServiceException{
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
	public SalesOrder fetchById(String id) throws SalesOrderCRUDServiceException{
		RestTemplate restTemplate = new RestTemplate();
		SalesOrder salesOrder = restTemplate.getForObject(SERVER_URI+SalesOrderRestURIConstants.GET_SALES_BY_ID+id, SalesOrder.class);
		return salesOrder;
	}

	@Override
	public SalesOrder create(SalesOrder entity) throws SalesOrderCRUDServiceException{
		RestTemplate restTemplate = new RestTemplate();
		SalesOrder salesOrder = restTemplate.postForObject(SERVER_URI + SalesOrderRestURIConstants.CREATE_SALES,entity,
				SalesOrder.class);
		return salesOrder;
	}

	@Override
	public SalesOrder update(SalesOrder entity, Long id) throws SalesOrderCRUDServiceException{
		RestTemplate restTemplate = new RestTemplate();
		SalesOrder salesOrder = restTemplate.postForObject(SERVER_URI+SalesOrderRestURIConstants.UPDATE_SALES+id, entity,SalesOrder.class);
		return salesOrder;
	}

	@Override
	public boolean delete(String id) throws SalesOrderCRUDServiceException{
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(SERVER_URI+SalesOrderRestURIConstants.DELETLE_SALES+id);
		return false;
	}

}
