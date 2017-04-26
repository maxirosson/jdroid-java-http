package com.jdroid.java.http.parser.json;

import com.jdroid.java.json.JSONObject;

public class ValueJsonParser extends JsonParser<JSONObject>  {
	
	private String key;
	
	public ValueJsonParser(String key) {
		this.key = key;
	}
	
	@Override
	public Object parse(JSONObject json) {
		return json.opt(key);
	}
}
