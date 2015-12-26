/**
 * 
 */
package com.crossover.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author bikash
 *
 */
@Entity
@Table(name="OrderLine")
public class OrderLine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(columnDefinition="product" , referencedColumnName="id" ,name="productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(columnDefinition="order" , referencedColumnName="id" ,name="salesOrderId")
	private SalesOrder order;
	
	@Column(name="productQuantity",nullable=false)
	private int productQuantity;
	
	@Column(name="price",nullable=false)
	private double productPrice;

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrder(SalesOrder order) {
		this.order = order;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

}
