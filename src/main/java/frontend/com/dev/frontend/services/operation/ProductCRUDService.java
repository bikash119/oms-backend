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

import com.crossover.assignment.model.Product;
import com.crossover.assignment.service.url.ProductRestURIConstants;
import com.dev.frontend.services.operation.exception.ProductCRUDServiceException;

/**
 * @author bikash
 *
 */
public class ProductCRUDService implements CRUDService<Product,ProductCRUDServiceException> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductCRUDService.class);

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Product> fetchAll() throws ProductCRUDServiceException{
		RestTemplate restTemplate = new RestTemplate();
		List<Product> products = new ArrayList<Product>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + ProductRestURIConstants.GET_ALL_PRODUCT,
				List.class);
		for (LinkedHashMap map : response) {
			Product product = new Product();
			product.setId(Long.parseLong(map.get("id").toString()));
			product.setDesc(map.get("desc").toString());
			product.setPrice(Float.parseFloat(map.get("price").toString()));
			product.setQuantity(Integer.parseInt(map.get("quantity").toString()));
			products.add(product);
		}
		return products;
	}

	@Override
	public Product fetchById(String id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product response = restTemplate.getForObject(SERVER_URI + ProductRestURIConstants.GET_PRODUCT_BY_ID+id,
				Product.class);
		return response;
	}

	@Override
	public Product create(Product entity) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.postForObject(SERVER_URI+ProductRestURIConstants.CREATE_PRODUCT, entity, Product.class);
		return product;
	}

	@Override
	public Product update(Product entity, Long id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.postForObject(SERVER_URI+ProductRestURIConstants.UPDATE_PRODUCT+id, entity, Product.class);
		return product;
	}

	@Override
	public boolean delete(Long id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(SERVER_URI+ProductRestURIConstants.DELETLE_PRODUCT);
		return false;
	}

}
