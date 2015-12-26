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

import com.crossover.assignment.dao.ProductDAO;
import com.crossover.assignment.model.Product;
import com.crossover.assignment.service.url.ProductRestURIConstants;

/**
 * @author bikash
 *
 */
@Controller
public class ProductController extends DefaultController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value=ProductRestURIConstants.PRODUCT_DUMMY,method= RequestMethod.GET)
	public @ResponseBody Product getDummyProduct(){
		logger.info("get dummy product");
		return null;
	}
	
	@RequestMapping(value=ProductRestURIConstants.GET_PRODUCT_BY_ID,method=RequestMethod.GET)
	public @ResponseBody Product getProductById(@PathVariable("id") long productId){
		logger.info("get product by id :"+productId);
		ProductDAO productDAO = getProductDAO();
		
		Product product = productDAO.fetchById(productId);
		return product;
		
	}
	
	//TODO implement pagination
	@RequestMapping(value = ProductRestURIConstants.GET_ALL_PRODUCT,method=RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){
		logger.info("get all products");
		ProductDAO productDAO = getProductDAO();
		return productDAO.fetchAll();
	}
	
	@RequestMapping(value=ProductRestURIConstants.CREATE_PRODUCT,method=RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product){
		logger.info("create product");
		ProductDAO productDAO = getProductDAO();
		return productDAO.save(product);
	}
	
	@RequestMapping(value=ProductRestURIConstants.UPDATE_PRODUCT,method=RequestMethod.POST)
	public @ResponseBody Product updateProduct(@RequestBody Product product,@PathVariable("id") long id){
		logger.info("update product");
		ProductDAO productDAO = getProductDAO();
		return productDAO.update(id, product);
	}
	
	@RequestMapping(value=ProductRestURIConstants.DELETLE_PRODUCT,method=RequestMethod.DELETE)
	public @ResponseBody void deleteProductById(@PathVariable("id") long id){
		ProductDAO productDAO = getProductDAO();
		productDAO.delete(id);
	}
	
	private ProductDAO getProductDAO(){
		return context.getBean(ProductDAO.class);
	}
	

}
