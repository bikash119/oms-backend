/**
 * 
 */
package com.crossover.assignment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bikash
 *
 */
public abstract class AbstractBusinessDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Transaction transaction;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
    public Session getSession(){
    	return this.getSessionFactory().getCurrentSession();
    }
    
    public void beginTransacation(){
    	transaction = getSession().beginTransaction();
    }
    
    public void commitTransaction(){
    	if(transaction != null){
    		transaction.commit();
    	}
    }

}
