package com.jdroid.java.http.exception;

import com.jdroid.java.exception.ErrorCode;
import com.jdroid.java.exception.ErrorCodeException;

public enum HttpErrorCode implements ErrorCode {
	
	CONNECTION_ERROR,
	HTTP_RESPONSE_ERROR;
	
	@Override
	public String getStatusCode() {
		return null;
	}
	
	@Override
	public Integer getTitleResId() {
		return null;
	}
	
	@Override
	public Integer getDescriptionResId() {
		return null;
	}
	
	@Override
	public ErrorCodeException newErrorCodeException(Object... errorCodeParameters) {
		return new ErrorCodeException(this, errorCodeParameters);
	}
	
	@Override
	public ErrorCodeException newErrorCodeException() {
		return new ErrorCodeException(this);
	}
	
	@Override
	public ErrorCodeException newErrorCodeException(Throwable throwable) {
		return new ErrorCodeException(this, throwable);
	}
	
	@Override
	public ErrorCodeException newErrorCodeException(String message) {
		return new ErrorCodeException(this, message);
	}
}