package com.crossover.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author bikash
 *
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="currentCredit",nullable=false)
	private float currentCredit;
	
	 @OneToMany(mappedBy="customer")
	 @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	 private List<SalesOrder> salesOrder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public float getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(float currentCredit) {
		this.currentCredit = currentCredit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
