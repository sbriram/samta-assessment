package com.samta.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	// default constructor to print default message
	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}

	// parameterized constructor to print message
	public ResourceNotFoundException(String message) {
		super("Resource not found on server !!");
	}

}
