package com.sezo.demo.exception;

public class GuestNotFoundException extends RuntimeException {

	public GuestNotFoundException(String message) {
		super(message);
	}

}
