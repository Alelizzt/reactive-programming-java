package com.system.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomException(String message, Throwable exception) {
		super(message, exception);
	}
}
