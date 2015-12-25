/**
 * 
 */
package com.crossover.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bikash
 *
 */
public abstract class DefaultController {
	
	protected ClassPathXmlApplicationContext context;
	public DefaultController() {
		if(context == null){
			context = new ClassPathXmlApplicationContext("spring.xml");
		}
	}
	

}
