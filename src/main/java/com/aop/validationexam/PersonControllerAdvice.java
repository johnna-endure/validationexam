package com.aop.validationexam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<String> validationHandler(ValidationException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(e.getMessage());
}
}
