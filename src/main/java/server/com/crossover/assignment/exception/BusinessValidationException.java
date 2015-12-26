/**
 * 
 */
package com.crossover.assignment.exception;

/**
 * @author bikash
 *
 */
public class BusinessValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessValidationException(String message,Throwable cause) {
		super(message, cause);
	}
	
	public BusinessValidationException(String message) {
		super(message);
	}
	
	public BusinessValidationException(Throwable cause) {
		super( cause);
	}
	

}
