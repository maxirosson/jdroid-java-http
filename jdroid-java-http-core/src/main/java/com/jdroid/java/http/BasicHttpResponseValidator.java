package com.jdroid.java.http;

import com.jdroid.java.exception.ConnectionException;
import com.jdroid.java.exception.HttpResponseException;

public class BasicHttpResponseValidator implements HttpServiceProcessor {

	private static final BasicHttpResponseValidator INSTANCE = new BasicHttpResponseValidator();

	protected BasicHttpResponseValidator() {
		// nothing...
	}

	public static BasicHttpResponseValidator get() {
		return INSTANCE;
	}

	@Override
	public void onInit(HttpService httpService) {
		// Do Nothing
	}

	@Override
	public void beforeExecute(HttpService httpService) {
		// Do Nothing
	}

	/**
	 * Validate the response generated by the server.
	 */
	@Override
	public void afterExecute(HttpService httpService, HttpResponseWrapper httpResponse) {
		String message = httpResponse.logStatusCode();
		if (httpResponse.isSuccess()) {
			onSuccess(httpResponse, message);
		} else if (httpResponse.isClientError()) {
			onClientError(httpResponse, message);
		} else if (httpResponse.isServerError()) {
			onServerError(httpResponse, message);
		} else {
			throw new HttpResponseException(message);
		}
	}

	protected void onSuccess(HttpResponseWrapper httpResponse, String message) {
		// Do Nothing
	}

	protected void onClientError(HttpResponseWrapper httpResponse, String message) {
		throw new HttpResponseException(message);
	}

	protected void onServerError(HttpResponseWrapper httpResponse, String message) {
		// 504 - Gateway Timeout
		if (httpResponse.getStatusCode() == 504) {
			throw new ConnectionException(message);
		} else {
			throw new HttpResponseException(message);
		}
	}
}
