package com.blacksw.advice;

public class EmailLoginFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailLoginFailedException() {
		super();
	}
	
	public EmailLoginFailedException(String message) {
		super(message);
	}
	
	public EmailLoginFailedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
