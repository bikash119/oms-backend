/**
 * 
 */
package com.dev.frontend.services.operation.exception;

/**
 * @author bikash
 *
 */
public class OrderLineCRUDServiceException extends CRUDServiceException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderLineCRUDServiceException(Throwable cause) {
		super(cause);
	}
	
	public OrderLineCRUDServiceException(String message,Throwable cause) {
		super(message,cause);
	}

	
	public OrderLineCRUDServiceException(String message) {
		super(message);
	}

}
