/**
 * 
 */
package com.crossover.assignment.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author bikash
 *
 */
@Entity
@Table(name="SalesOrder")
public class SalesOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="customer",nullable=false)
	private Customer customer;
	
	@Column(name="totalPrice",nullable=false)
	private float totalPrice;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<OrderLine> lineItems = new HashSet<OrderLine>();

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<OrderLine> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<OrderLine> lineItems) {
		this.lineItems = lineItems;
	}

}
