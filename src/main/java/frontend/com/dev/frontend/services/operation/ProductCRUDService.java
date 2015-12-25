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

import com.crossover.assignment.model.Product;
import com.crossover.assignment.service.url.ProductRestURIConstants;
import com.dev.frontend.services.operation.exception.ProductCRUDServiceException;

/**
 * @author bikash
 *
 */
public class ProductCRUDService implements CRUDService<Product, ProductCRUDServiceException> {

	private static final Logger logger = LoggerFactory.getLogger(ProductCRUDService.class);

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Product> fetchAll() throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		List<Product> products = new ArrayList<Product>();
		try {
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
		} catch (RestClientException e) {
			throw new ProductCRUDServiceException(e.getCause());
		}
		return products;
	}

	@Override
	public Product fetchById(String id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product product = null;
		try {
			product = restTemplate.getForObject(SERVER_URI + "/rest/product/" + id, Product.class);
		} catch (RestClientException e) {
			throw new ProductCRUDServiceException(e.getCause());
		}
		return product;
	}

	@Override
	public Product create(Product entity) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product product = null;
		try {
			product = restTemplate.postForObject(SERVER_URI + ProductRestURIConstants.CREATE_PRODUCT, entity,
					Product.class);
		} catch (RestClientException e) {
			throw new ProductCRUDServiceException(e.getCause());
		}
		return product;
	}

	@Override
	public Product update(Product entity, Long id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		Product product = null;
		try {
			product = restTemplate.postForObject(SERVER_URI + "/rest/product/update/" + id, entity, Product.class);
		} catch (RestClientException e) {
			throw new ProductCRUDServiceException(e.getCause());
		}
		return product;
	}

	@Override
	public boolean delete(String id) throws ProductCRUDServiceException {
		RestTemplate restTemplate = new RestTemplate();
		boolean isDeleted = true;
		try {
			restTemplate.delete(SERVER_URI + "/rest/product/delete/" + id);
		} catch (RestClientException e) {
			isDeleted = false;
			throw new ProductCRUDServiceException(e.getCause());
		}
		return isDeleted;
	}

}
