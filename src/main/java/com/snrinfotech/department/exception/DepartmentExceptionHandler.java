package com.snrinfotech.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler {

	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<String> handleDepartmentException(DepartmentException de){
		return new ResponseEntity(de.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
