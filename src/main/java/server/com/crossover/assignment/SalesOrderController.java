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

import com.crossover.assignment.model.SalesOrder;
import com.crossover.assignment.service.url.SalesOrderRestURIConstants;

/**
 * @author bikash
 *
 */
@Controller
public class SalesOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
	
	@RequestMapping(value=SalesOrderRestURIConstants.SALES_DUMMY,method= RequestMethod.GET)
	public @ResponseBody SalesOrder getDummySalesOrder(){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.GET_SALES_BY_ID,method=RequestMethod.GET)
	public @ResponseBody SalesOrder getSalesOrderById(@PathVariable("id") int custId){
		logger.info("");
		return null;
		
	}
	
	//TODO implement pagination
	@RequestMapping(value = SalesOrderRestURIConstants.GET_ALL_SALES,method=RequestMethod.GET)
	public @ResponseBody List<SalesOrder> getOrders(){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.CREATE_SALES,method=RequestMethod.POST)
	public @ResponseBody SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder){
		logger.info("");
		return null;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.UPDATE_SALES,method=RequestMethod.POST)
	public @ResponseBody SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder,@PathVariable("id") int id){
		logger.info("");
		return null;
	}
	

}
