package com.demosprnigbootapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CloudVendorExceptionHandler {
	@ExceptionHandler(value = { CloudVenderNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException
	(CloudVenderNotFoundException cloudVenderNotFoundException)
	{
		CloudVendorException cloudVendorException=new CloudVendorException(
				cloudVenderNotFoundException.getMessage(),
				cloudVenderNotFoundException.getCause(),
			HttpStatus.NOT_FOUND
				
				
				
				);
		return new ResponseEntity<> (cloudVendorException,HttpStatus.NOT_FOUND);
	}
	


}
