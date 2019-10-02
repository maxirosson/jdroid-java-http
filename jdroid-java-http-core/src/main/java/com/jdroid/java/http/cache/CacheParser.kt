package com.jdroid.java.http.cache

import com.jdroid.java.concurrent.ExecutorUtils
import com.jdroid.java.http.parser.Parser
import com.jdroid.java.utils.FileUtils
import com.jdroid.java.utils.LoggerUtils
import com.jdroid.java.utils.StreamUtils
import java.io.File
import java.io.IOException
import java.io.InputStream

class CacheParser(private val parser: Parser, private val cacheFile: File) : Parser {

    companion object {
        private val LOGGER = LoggerUtils.getLogger(CacheParser::class.java)
    }

    override fun parse(inputStream: InputStream): Any? {
        val inputStreamCopy = StreamUtils.copy(inputStream)
        val response = parser.parse(inputStreamCopy)

        ExecutorUtils.execute(Runnable {
            try {
                inputStreamCopy.reset()
                FileUtils.copyStream(inputStreamCopy, cacheFile)
                LOGGER.debug("Saved http request to cache file: " + cacheFile.absolutePath)
            } catch (e: IOException) {
                LoggerUtils.logHandledException(LOGGER, e)
            }
        })
        return response
    }

    override fun parse(input: String): Any? {
        return null
    }

}
