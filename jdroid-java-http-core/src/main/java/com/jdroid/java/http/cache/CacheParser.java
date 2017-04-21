package com.jdroid.java.http.cache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import com.jdroid.java.concurrent.ExecutorUtils;
import com.jdroid.java.http.parser.Parser;
import com.jdroid.java.utils.FileUtils;
import com.jdroid.java.utils.LoggerUtils;

public class CacheParser implements Parser {
	
	private static final Logger LOGGER = LoggerUtils.getLogger(CacheParser.class);
	
	private Parser parser;
	private File cacheFile;
	
	public CacheParser(Parser parser, File cacheFile) {
		this.parser = parser;
		this.cacheFile = cacheFile;
	}
	
	@Override
	public Object parse(InputStream inputStream) {
		
		final InputStream inputStreamCopy = FileUtils.copy(inputStream);
		Object object = parser.parse(inputStreamCopy);
		
		ExecutorUtils.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					inputStreamCopy.reset();
					FileUtils.copyStream(inputStreamCopy, cacheFile);
					LOGGER.debug("Saved http request to cache file: " + cacheFile.getAbsolutePath());
				} catch (IOException e) {
					LoggerUtils.logHandledException(LOGGER, e);
				}
			}
		});
		return object;
	}
	
	@Override
	public Object parse(String input) {
		return null;
	}
	
}
