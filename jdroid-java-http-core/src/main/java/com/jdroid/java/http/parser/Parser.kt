package com.jdroid.java.http.parser

import java.io.InputStream

interface Parser {

    /**
     * Parse the inputStream
     *
     * @param inputStream The inputStream to parse
     * @return The parser response object
     */
    fun parse(inputStream: InputStream): Any?

    /**
     * Parse the String
     *
     * @param input The input to parse
     * @return The parser response object
     */
    fun parse(input: String): Any?
}
