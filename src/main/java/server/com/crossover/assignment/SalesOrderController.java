/**
 * 
 */
package com.crossover.assignment;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import com.crossover.assignment.dao.CustomerDAO;
import com.crossover.assignment.dao.OrderLineDAO;
import com.crossover.assignment.dao.ProductDAO;
import com.crossover.assignment.dao.SalesOrderDAO;
import com.crossover.assignment.exception.BusinessValidationException;
import com.crossover.assignment.model.Customer;
import com.crossover.assignment.model.OrderLine;
import com.crossover.assignment.model.Product;
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
		Set<OrderLine> lineItems = salesOrder.getLineItems();
		
		/*
		 * A better approach would have been to spawn a business workflow which does each of the below step as workflow steps.
		 * Because of time constraint I have stuff everything in controller.
		 */
		SalesOrder order = null;
		try {
			
			boolean isValidTx = performBusinessValidation(salesOrder);
			boolean isInventorySufficient = performInventoryCheck(salesOrder);
			if(isValidTx && isInventorySufficient){
				order = salesOrderDao.save(salesOrder);
				for (OrderLine orderLine : lineItems) {
					OrderLineDAO lineItemDao = getLineItemDao();
					orderLine.setOrder(order);
					lineItemDao.save(orderLine);
				}
				updateCustomerCurrentCredit(salesOrder);
				updateProductInventory(salesOrder);
			}else if(!isValidTx){
				try {
					throw new BusinessValidationException("Credit limit reached. No more purchase allowed");
				} catch (BusinessValidationException e) {
					e.printStackTrace();
					throw new RestClientException(e.getMessage(),e.getCause());
				}
			}else if(!isInventorySufficient){
				try {
					throw new BusinessValidationException("Insufficient Inventory");
				} catch (BusinessValidationException e) {
					e.printStackTrace();
					throw new RestClientException(e.getMessage(),e.getCause());
				}
			}
		} catch (Exception e) {
			throw new RestClientException(e.getMessage(), e.getCause());
		}
		return order;
	}
	

	private void updateProductInventory(SalesOrder salesOrder) {
		ProductDAO productDao = getProductDao();
		Set<OrderLine> lineItems = salesOrder.getLineItems();
		for (OrderLine orderLine : lineItems) {
			Product product = orderLine.getProduct();
			long updatedInventory = product.getQuantity() - orderLine.getProductQuantity();
			product.setQuantity(updatedInventory);
			productDao.update(product.getId(), product);
		}
	}

	private void updateCustomerCurrentCredit(SalesOrder salesOrder) {
		CustomerDAO customerDAO = getCustomerDAO();
		customerDAO.update(salesOrder.getCustomer().getId(), salesOrder.getCustomer());
	}

	private boolean performBusinessValidation(SalesOrder salesOrder) {
		Customer customer = salesOrder.getCustomer();
		double totalPrice = salesOrder.getTotalPrice();
		boolean validTx = false;
		if(customer.getCurrentCredit() < totalPrice){
			validTx = false;
		}else{
			validTx = true;
		}
		return validTx;
	}
	
	private boolean performInventoryCheck(SalesOrder salesOrder){
		boolean isInventorySufficient = true;
		Set<OrderLine> lineItems = salesOrder.getLineItems();
		for (OrderLine orderLine : lineItems) {
			long availableQuantity = orderLine.getProduct().getQuantity();
			int requestedQuantity = orderLine.getProductQuantity();
			if(availableQuantity < requestedQuantity){
				isInventorySufficient = false;
				return isInventorySufficient;
			}
		}
		return isInventorySufficient;
	}

	@RequestMapping(value=SalesOrderRestURIConstants.UPDATE_SALES,method=RequestMethod.POST)
	public @ResponseBody SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder,@PathVariable("id") long id){
		logger.info("update sales order");
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		SalesOrder updatedSalesOrder = salesOrderDao.update(id, salesOrder);
		return updatedSalesOrder;
	}
	
	@RequestMapping(value= SalesOrderRestURIConstants.DELETLE_SALES,method= RequestMethod.DELETE)
	public @ResponseBody void deleteSalesOrder(@PathVariable("id") long id){
		SalesOrderDAO salesOrderDao = getSalesOrderDao();
		salesOrderDao.delete(id);
	}
	
	private ProductDAO getProductDao(){
		ProductDAO productDao = context.getBean(ProductDAO.class);
		return productDao;
	}
	
	private CustomerDAO getCustomerDAO(){
		CustomerDAO customerDao = context.getBean(CustomerDAO.class);
		return customerDao;
	}
	
	private SalesOrderDAO getSalesOrderDao(){
		SalesOrderDAO salesOrderDAO = context.getBean(SalesOrderDAO.class);
		return salesOrderDAO;
	}
	private OrderLineDAO getLineItemDao() {
		OrderLineDAO orderLineDao = context.getBean(OrderLineDAO.class);
		return orderLineDao;
	}
	
}
