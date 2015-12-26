/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.OrderLineDAO;
import com.crossover.assignment.model.OrderLine;

/**
 * @author bikash
 *
 */
public class OrderLineDAOImpl extends AbstractBusinessDAO implements OrderLineDAO {

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#save(com.crossover.assignment.model.OrderLine)
	 */
	@Override
	public OrderLine save(OrderLine orderLine) {
		try {
			beginTransacation();
			this.getSession().save(orderLine);
			return orderLine;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> fetchAll() {
		try {
			beginTransacation();
			return this.getSession().createQuery("from OrderLine").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#fetchById(java.lang.String)
	 */
	@Override
	public OrderLine fetchById(String id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			StringBuilder queryBuilder = new StringBuilder(" from OrderLine");
			queryBuilder.append(" where id = "+ id);
			Query query = session.createQuery(queryBuilder.toString());
			@SuppressWarnings("unchecked")
			List<OrderLine> orderLines = query.list();
			OrderLine orderline = (orderLines != null && !orderLines.isEmpty()) ? orderLines.get(0): null;
			return orderline;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(long id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			OrderLine orderLine = (OrderLine)session.load(OrderLine.class, id);
			if(orderLine != null){
				session.delete(orderLine);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.OrderLineDAO#update(java.lang.String, com.crossover.assignment.model.OrderLine)
	 */
	@Override
	public OrderLine update(long id, OrderLine orderLine) {
		try {
			beginTransacation();
			this.getSession().update(String.valueOf(id), orderLine);
			return orderLine;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

}
