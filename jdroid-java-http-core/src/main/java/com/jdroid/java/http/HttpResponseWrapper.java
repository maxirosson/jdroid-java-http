package com.jdroid.java.http;

import com.jdroid.java.utils.LoggerUtils;

import org.slf4j.Logger;

import java.io.InputStream;

public abstract class HttpResponseWrapper {
	
	private final static Logger LOGGER = LoggerUtils.getLogger(HttpResponseWrapper.class);
	
	public abstract int getStatusCode();
	
	public abstract String getStatusReason();
	
	public abstract String getHeader(String name);
	
	protected String logStatusCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP Status code: ");
		sb.append(getStatusCode());
		sb.append(" Reason: ");
		sb.append(getStatusReason());
		if (isSuccess()) {
			LOGGER.debug(sb.toString());
		} else {
			LOGGER.warn(sb.toString());
		}
		return sb.toString();
	}
	
	public Boolean isSuccess() {
		int code = getStatusCode();
		return (code >= 200) && (code <= 299);
	}
	
	public Boolean isClientError() {
		int code = getStatusCode();
		return (code >= 400) && (code <= 499);
	}
	
	public Boolean isServerError() {
		int code = getStatusCode();
		return (code >= 500) && (code <= 599);
	}

	public abstract InputStream getInputStream();
}
