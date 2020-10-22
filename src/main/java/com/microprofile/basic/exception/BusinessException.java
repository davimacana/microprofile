/**
 * 
 */
package com.microprofile.basic.exception;

/**
 * @author Davi Maçana
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}
}
