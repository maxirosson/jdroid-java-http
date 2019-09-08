package com.jdroid.java.http.parser.json

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jdroid.java.date.DateConfiguration
import com.jdroid.java.http.parser.Parser
import com.jdroid.java.utils.StreamUtils
import java.io.InputStream
import java.lang.reflect.Type

open class GsonParser(private val type: Type) : Parser {

    override fun parse(inputStream: InputStream): Any? {
        val content = StreamUtils.toString(inputStream)
        return if (content.isNotBlank()) parse(content) else null
    }

    override fun parse(input: String): Any? {
        return createGson().fromJson<Any>(input, type)
    }

    protected open fun createGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat(DateConfiguration.getDefaultDateTimeFormat())
        return gsonBuilder.create()
    }
}
