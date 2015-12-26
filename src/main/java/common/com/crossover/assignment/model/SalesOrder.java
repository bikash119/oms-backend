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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

/**
 * @author bikash
 *
 */
@Entity
@Table(name = "SalesOrder")
public class SalesOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition="customer" , referencedColumnName="id" ,name="customerId")
	private Customer customer;

	@Column(name = "totalPrice", nullable = false)
	private double totalPrice;

	@OneToMany(mappedBy="order",fetch = FetchType.EAGER)
	private Set<OrderLine> lineItems = new HashSet<OrderLine>();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<OrderLine> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<OrderLine> lineItems) {
		this.lineItems = lineItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
