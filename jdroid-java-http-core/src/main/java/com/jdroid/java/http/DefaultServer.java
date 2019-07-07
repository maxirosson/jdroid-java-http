package com.jdroid.java.http;

import com.jdroid.java.collections.Lists;

import java.util.List;

public class DefaultServer implements Server {
	
	private String name;
	private String baseUrl;
	private Boolean supportsSsl;
	
	public DefaultServer(String name, String baseUrl, Boolean supportsSsl) {
		this.name = name;
		this.baseUrl = baseUrl;
		this.supportsSsl = supportsSsl;
	}
	
	public DefaultServer(String baseUrl) {
		this(DefaultServer.class.getSimpleName(), baseUrl, true);
	}
	
	@Override
	public String getServerName() {
		return name;
	}
	
	@Override
	public String getBaseUrl() {
		return baseUrl;
	}
	
	@Override
	public boolean supportsSsl() {
		return supportsSsl;
	}
	
	@Override
	public boolean isProduction() {
		return true;
	}
	
	@Override
	public List<HttpServiceProcessor> getHttpServiceProcessors() {
		return Lists.newArrayList(new BasicHttpResponseValidator());
	}
	
	@Override
	public Server instance(String name) {
		return null;
	}
}
