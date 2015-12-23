/**
 * 
 */
package com.crossover.assignment.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author bikash
 *
 */
public class SalesOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private Customer customer;
	
	private float totalPrice;
	
	private List<OrderLine> lineItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderLine> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<OrderLine> lineItems) {
		this.lineItems = lineItems;
	}

}
