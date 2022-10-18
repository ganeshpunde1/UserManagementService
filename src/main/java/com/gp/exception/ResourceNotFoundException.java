package com.gp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2874925465100874092L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String string) {
		super(string);
	}

}
