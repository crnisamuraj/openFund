package com.merkaba.samurai.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 4831587330745537140L;

	private HttpStatus hStatus;

	public CustomException(String message, HttpStatus hStatus) {
		super(message);
		this.hStatus = hStatus;
	}

	/**
	 * @return the hStatus
	 */
	public HttpStatus gethStatus() {
		return hStatus;
	}

	/**
	 * @param hStatus the hStatus to set
	 */
	public void sethStatus(HttpStatus hStatus) {
		this.hStatus = hStatus;
	}
}
