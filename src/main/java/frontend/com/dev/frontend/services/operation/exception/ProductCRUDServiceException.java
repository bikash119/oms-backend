/**
 * 
 */
package com.dev.frontend.services.operation.exception;

/**
 * @author bikash
 *
 */
public class ProductCRUDServiceException extends CRUDServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductCRUDServiceException(Throwable cause) {
		super(cause);
	}
	
	public ProductCRUDServiceException(String message,Throwable cause) {
		super(message,cause);
	}

	
	public ProductCRUDServiceException(String message) {
		super(message);
	}


}
