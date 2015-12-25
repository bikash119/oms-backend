/**
 * 
 */
package com.dev.frontend.services.operation.exception;

/**
 * @author bikash
 *
 */
public class CRUDServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CRUDServiceException() {
	}

	public CRUDServiceException(String message, Throwable th) {
		super(message, th);
	}

	public CRUDServiceException(String message) {
		super(message);
	}

	public CRUDServiceException(Throwable th) {
		super(th);
	}

}
