package com.demosprnigbootapi.exception;

/**
 * @author Vijendra
 *
 */
public class CloudVenderNotFoundException extends RuntimeException{
	
	public CloudVenderNotFoundException(String message) {
        super(message);
    }

    // Constructor with a custom message and a cause
    public CloudVenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
	
	

}
