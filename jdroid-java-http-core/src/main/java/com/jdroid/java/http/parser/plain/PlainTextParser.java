package com.jdroid.java.http.parser.plain;

import com.jdroid.java.utils.LoggerUtils;
import com.jdroid.java.utils.StreamUtils;
import org.slf4j.Logger;

import java.io.InputStream;

public abstract class PlainTextParser implements com.jdroid.java.http.parser.Parser {
	
	private static final Logger LOGGER = LoggerUtils.getLogger(PlainTextParser.class);
	
	/**
	 * @see com.jdroid.java.http.parser.Parser#parse(java.io.InputStream)
	 */
	@Override
	public Object parse(InputStream inputStream) {
		LOGGER.debug("Parsing started.");
		try {
			// Read the plain text response
			String result = StreamUtils.toString(inputStream);
			LOGGER.debug(result);
			
			// Parse the plain text
			return parse(result);
		} finally {
			LOGGER.debug("Parsing finished.");
		}
	}
	
	/**
	 * @see com.jdroid.java.http.parser.Parser#parse(java.lang.String)
	 */
	@Override
	public abstract Object parse(String plainText);
}