/**
 * 
 */
package com.dev.frontend.services.operation.exception;

/**
 * @author bikash
 *
 */
public class SalesOrderCRUDServiceException extends CRUDServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SalesOrderCRUDServiceException(Throwable cause) {
		super(cause);
	}
	
	public SalesOrderCRUDServiceException(String message,Throwable cause) {
		super(message,cause);
	}

	
	public SalesOrderCRUDServiceException(String message) {
		super(message);
	}


}
