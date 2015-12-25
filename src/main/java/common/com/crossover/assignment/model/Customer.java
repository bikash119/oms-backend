package com.crossover.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="currentCredit",nullable=false)
	private float currentCredit;
	
	 @OneToOne(mappedBy="customer")
	 @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	 private SalesOrder salesOrder;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
