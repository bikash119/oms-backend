/**
 * 
 */
package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.crossover.assignment.model.Product;
import com.crossover.assignment.service.url.ProductRestURIConstants;

/**
 * @author bikash
 *
 */
public class ProductFetchService implements FetchService<Product> {

	@Override
	public List<Product> fetchAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Product> products = new ArrayList<Product>();
		List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI + ProductRestURIConstants.GET_ALL_PRODUCT,
				List.class);
		for (LinkedHashMap map : response) {
			Product product = new Product();
			product.setId(map.get("id").toString());
			product.setDesc(map.get("desc").toString());
			product.setPrice(Float.parseFloat(map.get("price").toString()));
			product.setQuantity(Integer.parseInt(map.get("quantity").toString()));
			products.add(product);
		}
		return products;
	}

	@Override
	public Product fetchById(int id) {
		return null;
	}

}
