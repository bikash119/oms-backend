/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.SalesOrderDAO;
import com.crossover.assignment.model.OrderLine;
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
		try {
			beginTransacation();
			this.getSession().save(salesOrder);
			return salesOrder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#fetchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesOrder> fetchAll() {
		try {
			beginTransacation();
			return this.getSession().createQuery("from SalesOrder").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#fetchById(java.lang.String)
	 */
	@Override
	public SalesOrder fetchById(long id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			StringBuilder queryBuilder = new StringBuilder(" from SalesOrder");
			queryBuilder.append(" where id = " + id);
			Query query = session.createQuery(queryBuilder.toString());
			@SuppressWarnings("unchecked")
			List<SalesOrder> salesOrders = query.list();
			return (salesOrders != null && !salesOrders.isEmpty()) ? salesOrders.get(0) : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.SalesOrderDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(long id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			SalesOrder salesOrder = (SalesOrder)session.load(SalesOrder.class,id);
			if(salesOrder != null){
				session.delete(salesOrder);
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
	 * @see com.crossover.assignment.dao.SalesOrderDAO#update(java.lang.String, com.crossover.assignment.model.SalesOrder)
	 */
	@Override
	public SalesOrder update(long id, SalesOrder salesOrder) {
		try {
			beginTransacation();
			this.getSession().update(String.valueOf(id),salesOrder);
			return salesOrder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

}
