package com.jdroid.java.http.parser.plain

import com.jdroid.java.utils.LoggerUtils
import com.jdroid.java.utils.StreamUtils
import java.io.InputStream

abstract class PlainTextParser : com.jdroid.java.http.parser.Parser {

    override fun parse(inputStream: InputStream): Any {
        LOGGER.debug("Parsing started.")
        try {
            // Read the plain text response
            val result = StreamUtils.toString(inputStream)
            LOGGER.debug(result)

            // Parse the plain text
            return parse(result)
        } finally {
            LOGGER.debug("Parsing finished.")
        }
    }

    abstract override fun parse(input: String): Any

    companion object {

        private val LOGGER = LoggerUtils.getLogger(PlainTextParser::class.java)
    }
}