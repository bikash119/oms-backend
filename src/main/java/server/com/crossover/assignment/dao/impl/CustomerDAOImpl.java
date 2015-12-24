/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> fetchAll() {
		SessionFactory factory = this.getSessionFactory();
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from customer").list();
		return customers;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchById(java.lang.String)
	 */
	@Override
	public Customer fetchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#delete(java.lang.String)
	 */
	@Override
	public Customer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.CustomerDAO#update(java.lang.String, com.crossover.assignment.model.Customer)
	 */
	@Override
	public Customer update(String id, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
