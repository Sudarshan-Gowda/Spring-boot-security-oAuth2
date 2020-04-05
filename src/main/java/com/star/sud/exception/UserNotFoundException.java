/**
 * 
 */
package com.star.sud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sudarshan
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079985748306399433L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
