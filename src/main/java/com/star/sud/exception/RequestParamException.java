package com.star.sud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestParamException extends Exception {

	private static final long serialVersionUID = 8375200030731629732L;

	public RequestParamException(String message) {
		super(message);
	}

}
