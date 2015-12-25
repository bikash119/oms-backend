/**
 * 
 */
package com.dev.frontend.services.operation.exception;

/**
 * @author bikash
 *
 */
public class CustomerCRUDServiceException extends CRUDServiceException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerCRUDServiceException(Throwable cause) {
		super(cause);
	}
	
	public CustomerCRUDServiceException(String message,Throwable cause) {
		super(message,cause);
	}

	
	public CustomerCRUDServiceException(String message) {
		super(message);
	}

}
