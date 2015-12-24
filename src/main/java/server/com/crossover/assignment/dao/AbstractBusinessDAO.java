/**
 * 
 */
package com.crossover.assignment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author bikash
 *
 */
public abstract class AbstractBusinessDAO {
	
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
    public Session getSession(){
    	return this.getSessionFactory().openSession();
    }

}
