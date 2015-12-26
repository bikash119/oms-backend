/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crossover.assignment.dao.AbstractBusinessDAO;
import com.crossover.assignment.dao.ProductDAO;
import com.crossover.assignment.model.Product;

/**
 * @author bikash
 *
 */
public class ProductDAOImpl extends AbstractBusinessDAO implements ProductDAO {

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#save(com.crossover.assignment.model.Product)
	 */
	@Override
	public Product save(Product product) {
		try {
			beginTransacation();
			this.getSession().persist(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#fetchAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> fetchAll() {
		try {
			beginTransacation();
			return this.getSession().createQuery("from Product").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#fetchById(java.lang.String)
	 */
	@Override
	public Product fetchById(long id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			StringBuilder queryBuilder = new StringBuilder(" from Product");
			queryBuilder.append(" where id = "+ id);
			Query query = session.createQuery(queryBuilder.toString());
			@SuppressWarnings("unchecked")
			List<Product> products = query.list();
			Product product = (products != null && !products.isEmpty()) ? products.get(0): null;
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(long id) {
		try {
			beginTransacation();
			Session session = this.getSession();
			Product product = (Product)session.load(Product.class, id);
			if(product != null){
				session.delete(product);
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
	 * @see com.crossover.assignment.dao.ProductDAO#update(java.lang.String, com.crossover.assignment.model.Product)
	 */
	@Override
	public Product update(long id, Product product) {
		try {
			beginTransacation();
			this.getSession().update(String.valueOf(id), product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			commitTransaction();
		}
	}

}
