package com.jdroid.java.http.parser.zip

import com.jdroid.java.exception.UnexpectedException
import com.jdroid.java.http.parser.Parser
import com.jdroid.java.utils.LoggerUtils
import java.io.IOException
import java.io.InputStream
import java.util.zip.ZipInputStream

/**
 * Parser used to handle a file contained inside a zip.
 * @param innerParser [com.jdroid.java.http.parser.Parser] to use to handle the extracted file.
 * @param fileName Name of the file to extract of the zip.
 */
class ZipFileParser(private val innerParser: Parser, private val fileName: String) : Parser {

    override fun parse(inputStream: InputStream): Any? {

        val zipInputStream = ZipInputStream(inputStream)
        try {
            var entry = zipInputStream.nextEntry
            while (entry != null) {
                if (entry.name == fileName) {
                    LOGGER.debug("Starting to parse $fileName file.")
                    return innerParser.parse(zipInputStream)
                }
                entry = zipInputStream.nextEntry
            }
        } catch (e: IOException) {
            throw UnexpectedException(e)
        }

        return null
    }

    override fun parse(input: String): Any? {
        return null
    }

    companion object {
        private val LOGGER = LoggerUtils.getLogger(ZipFileParser::class.java)
    }
}
