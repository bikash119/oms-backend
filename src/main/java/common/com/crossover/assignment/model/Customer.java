package com.crossover.assignment.model;

import java.io.Serializable;

/**
 * @author bikash
 *
 */
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String phoneNumber;
	
	private float currentCredit;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
