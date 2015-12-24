/**
 * 
 */
package com.crossover.assignment.dao.impl;

import java.util.List;

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
		this.getSession().persist(product);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#fetchAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> fetchAll() {
		return this.getSession().createQuery("from Product").list();
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#fetchById(java.lang.String)
	 */
	@Override
	public Product fetchById(String id) {
		return (Product)this.getSession().load(Product.class, id);
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#delete(java.lang.String)
	 */
	@Override
	public Product delete(String id) {
		Session session = this.getSession();
		Product product = (Product)session.load(Product.class, id);
		if(product != null){
			session.delete(product);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.crossover.assignment.dao.ProductDAO#update(java.lang.String, com.crossover.assignment.model.Product)
	 */
	@Override
	public Product update(String id, Product product) {
		this.getSession().update(id, product);
		return product;
	}

}