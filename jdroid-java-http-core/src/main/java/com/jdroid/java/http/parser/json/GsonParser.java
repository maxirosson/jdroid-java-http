package com.jdroid.java.http.parser.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jdroid.java.date.DateConfiguration;
import com.jdroid.java.http.parser.Parser;
import com.jdroid.java.utils.StreamUtils;
import com.jdroid.java.utils.StringUtils;

import java.io.InputStream;
import java.lang.reflect.Type;

public class GsonParser implements Parser {
	
	private Type type;
	
	public GsonParser(Type type) {
		this.type = type;
	}
	
	@Override
	public Object parse(InputStream inputStream) {
		String content = StreamUtils.toString(inputStream);
		return StringUtils.isNotBlank(content) ? parse(content) : null;
	}
	
	@Override
	public Object parse(String input) {
		return createGson().fromJson(input, type);
	}
	
	protected Gson createGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat(DateConfiguration.INSTANCE.getDefaultDateTimeFormat());
		return gsonBuilder.create();
	}
}
