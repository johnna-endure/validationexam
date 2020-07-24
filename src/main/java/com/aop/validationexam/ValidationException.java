package com.aop.validationexam;

public class ValidationException extends RuntimeException {
	public ValidationException(String description) {
		super(description);
	}
}
