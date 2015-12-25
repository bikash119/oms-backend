/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.CustomerDAO;
import com.crossover.assignment.model.Customer;

/**
 * @author bikash
 *
 */
@Transactional
public class CustomerDAOImpl extends AbstractBusinessDAO implements CustomerDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.crossover.assignment.dao.CustomerDAO#save(com.crossover.assignment.
	 * model.Customer)
	 */
	@Override
	public Customer save(Customer customer) {
		try {
			beginTransacation();
			Serializable savedCustomer = this.getSession().save(customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			commitTransaction();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override

	public List<Customer> fetchAll() {
		try {
			beginTransacation();
			List<Customer> customers = this.getSession().createQuery("from Customer").list();
			return customers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			commitTransaction();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.crossover.assignment.dao.CustomerDAO#fetchById(java.lang.String)
	 */
	@Override
	public Customer fetchById(String id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			StringBuilder queryBuilder = new StringBuilder(" from Customer");
			queryBuilder.append(" where id = " + id);
			Query query = session.createQuery(queryBuilder.toString());
			List<Customer> customers = query.list();
			Customer customer = (customers != null && !customers.isEmpty()) ? customers.get(0) : null;
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			commitTransaction();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.crossover.assignment.dao.CustomerDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			Object load = session.load(Customer.class, id);
			if (load != null) {
				session.delete(load);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			commitTransaction();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.crossover.assignment.dao.CustomerDAO#update(java.lang.String,
	 * com.crossover.assignment.model.Customer)
	 */
	@Override
	public Customer update(String id, Customer customer) {
		try {
			beginTransacation();
			this.getSession().update(id, customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

}
