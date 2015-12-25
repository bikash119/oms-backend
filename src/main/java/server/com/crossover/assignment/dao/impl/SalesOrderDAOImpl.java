/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.SalesOrderDAO;
import com.crossover.assignment.model.SalesOrder;

/**
 * @author bikash
 *
 */
public class SalesOrderDAOImpl extends AbstractBusinessDAO implements SalesOrderDAO {

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#save(com.crossover.assignment.model.SalesOrder)
	 */
	@Override
	public SalesOrder save(SalesOrder salesOrder) {
		this.getSession().save(salesOrder);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesOrder> fetchAll() {
		return this.getSession().createQuery("from SalesOrder").list();
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#fetchById(java.lang.String)
	 */
	@Override
	public SalesOrder fetchById(String id) {
		return (SalesOrder) this.getSession().load(SalesOrder.class, id);
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#delete(java.lang.String)
	 */
	@Override
	public SalesOrder delete(String id) {
		Session session = this.getSession();
		Object salesOrder = session.load(SalesOrder.class,id);
		if(salesOrder != null){
			session.delete(salesOrder);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#update(java.lang.String, com.crossover.assignment.model.SalesOrder)
	 */
	@Override
	public SalesOrder update(String id, SalesOrder salesOrder) {
		this.getSession().update(id,salesOrder);
		return salesOrder;
	}

}
