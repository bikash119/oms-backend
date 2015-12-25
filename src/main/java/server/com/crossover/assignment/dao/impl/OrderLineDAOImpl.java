/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.model.OrderLine;

/**
 * @author bikash
 *
 */
public class OrderLineDAOImpl extends AbstractBusinessDAO implements com.crossover.assignment.dao.OrderLineDAO {

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#save(com.crossover.assignment.model.OrderLine)
	 */
	@Override
	public OrderLine save(OrderLine orderLine) {
		this.getSession().persist(orderLine);
		return orderLine;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> fetchAll() {
		return this.getSession().createQuery("from OrderLine").list();
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#fetchById(java.lang.String)
	 */
	@Override
	public OrderLine fetchById(String id) {
		return (OrderLine) this.getSession().load(OrderLine.class, id);
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#delete(java.lang.String)
	 */
	@Override
	public OrderLine delete(String id) {
		Session session = this.getSession();
		Object orderLine = session.load(OrderLine.class, id);
		if(orderLine != null){
			session.delete(orderLine);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#update(java.lang.String, com.crossover.assignment.model.OrderLine)
	 */
	@Override
	public OrderLine update(String id, OrderLine orderLine) {
		this.getSession().update(id, orderLine);
		return orderLine;
	}

}
