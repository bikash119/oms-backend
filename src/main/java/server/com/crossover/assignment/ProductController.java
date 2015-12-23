/**
 * 
 */
package com.crossover.assignment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.assignment.model.Product;
import com.crossover.assignment.service.url.ProductRestURIConstants;

/**
 * @author bikash
 *
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value=ProductRestURIConstants.PRODUCT_DUMMY,method= RequestMethod.GET)
	public @ResponseBody Product getDummyProduct(){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=ProductRestURIConstants.GET_PRODUCT_BY_ID,method=RequestMethod.GET)
	public @ResponseBody Product getProductById(@PathVariable("id") int custId){
		logger.info("");
		return null;
		
	}
	
	//TODO implement pagination
	@RequestMapping(value = ProductRestURIConstants.GET_ALL_PRODUCT,method=RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=ProductRestURIConstants.CREATE_PRODUCT,method=RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=ProductRestURIConstants.UPDATE_PRODUCT,method=RequestMethod.POST)
	public @ResponseBody Product updateCustomer(@RequestBody Product product,@PathVariable("id") int id){
		logger.info("");
		return null;
	}
	

}
