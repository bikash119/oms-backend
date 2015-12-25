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

import com.crossover.assignment.dao.SalesOrderDAO;
import com.crossover.assignment.model.SalesOrder;
import com.crossover.assignment.service.url.SalesOrderRestURIConstants;

/**
 * @author bikash
 *
 */
@Controller
public class SalesOrderController extends DefaultController {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
	
	@RequestMapping(value=SalesOrderRestURIConstants.SALES_DUMMY,method= RequestMethod.GET)
	public @ResponseBody SalesOrder getDummySalesOrder(){
		logger.info("get dummy sales order");
		return null;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.GET_SALES_BY_ID,method=RequestMethod.GET)
	public @ResponseBody SalesOrder getSalesOrderById(@PathVariable("id") String orderId){
		logger.info("get sales order by id :"+orderId);
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		SalesOrder salesOrder = salesOrderDao.fetchById(orderId);
		return salesOrder;
		
	}
	
	//TODO implement pagination
	@RequestMapping(value = SalesOrderRestURIConstants.GET_ALL_SALES,method=RequestMethod.GET)
	public @ResponseBody List<SalesOrder> getOrders(){
		logger.info("get all orders");
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		List<SalesOrder> salesOrders = salesOrderDao.fetchAll();
		return salesOrders;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.CREATE_SALES,method=RequestMethod.POST)
	public @ResponseBody SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder){
		logger.info("create sales order");
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		SalesOrder order = salesOrderDao.save(salesOrder);
		return order;
	}
	
	@RequestMapping(value=SalesOrderRestURIConstants.UPDATE_SALES,method=RequestMethod.POST)
	public @ResponseBody SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder,@PathVariable("id") String id){
		logger.info("update sales order");
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		SalesOrder updatedSalesOrder = salesOrderDao.update(id, salesOrder);
		return updatedSalesOrder;
	}
	
	@RequestMapping(value= SalesOrderRestURIConstants.DELETLE_SALES,method= RequestMethod.DELETE)
	public @ResponseBody void deleteSalesOrder(@PathVariable("id") String id){
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		salesOrderDao.delete(id);
	}
	
	private SalesOrderDAO getSalesOrderDao(){
		SalesOrderDAO salesOrderDAO = this.context.getBean(SalesOrderDAO.class);
		return salesOrderDAO;
	}
	
}
