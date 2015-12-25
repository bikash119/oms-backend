/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.CustomerDAO;
import com.crossover.assignment.model.Customer;

/**
 * @author bikash
 *
 */
public class CustomerDAOImpl extends AbstractBusinessDAO implements CustomerDAO  {
	
	
	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#save(com.crossover.assignment.model.Customer)
	 */
	@Override
	public Customer save(Customer customer) {
		Serializable savedCustomer = this.getSession().save(customer);
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> fetchAll() {
		List<Customer> customers = this.getSession().createQuery("from Customer").list();
		return customers;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchById(java.lang.String)
	 */
	@Override
	public Customer fetchById(String id) {
		Session session = this.getSession();
		StringBuilder queryBuilder = new StringBuilder(" from Customer");
		queryBuilder.append(" where id = "+ id );
		Query query = session.createQuery(queryBuilder.toString());
		List<Customer> customers = query.list();
		Customer customer = (customers != null && !customers.isEmpty()) ? customers.get(0): null;
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String id) {
		Session session = this.getSession();
		Object load = session.load(Customer.class, id);
		if(load != null){
			session.delete(load);
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#update(java.lang.String, com.crossover.assignment.model.Customer)
	 */
	@Override
	public Customer update(String id, Customer customer) {
		this.getSession().update(id, customer);
		return customer;
	}

}
