package com.jdroid.java.http.exception;


import com.jdroid.java.exception.ErrorCodeException;

/**
 * Exception thrown when there are unknown HTTP errors while communicating with the server.
 */
public class HttpResponseException extends ErrorCodeException {
	
	private static final long serialVersionUID = -1165226174367435109L;
	
	public HttpResponseException(String message) {
		super(HttpErrorCode.HTTP_RESPONSE_ERROR, message);
		setTrackable(true);
	}
	
}
