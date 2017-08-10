package com.jdroid.java.http.parser.json;

import com.google.gson.Gson;
import com.jdroid.java.http.parser.Parser;
import com.jdroid.java.utils.FileUtils;
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
		String content = FileUtils.toString(inputStream);
		return StringUtils.isNotBlank(content) ? parse(content) : null;
	}
	
	@Override
	public Object parse(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, type);
	}
}
