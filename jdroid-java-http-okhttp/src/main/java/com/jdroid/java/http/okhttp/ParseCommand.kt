package com.jdroid.java.http.okhttp

import com.jdroid.java.exception.UnexpectedException
import com.jdroid.java.http.parser.Parser

import java.io.IOException
import java.io.InputStream

class ParseCommand(private val parser: Parser) : OkHttpCommand<InputStream, Any>() {

    @Throws(IOException::class)
    override fun doExecute(inputStream: InputStream): Any? {
        try {
            return parser.parse(inputStream)
        } catch (e: UnexpectedException) {
            val throwable = e.cause
            if (throwable is IOException) {
                throw throwable
            } else {
                throw e
            }
        }
    }
}
