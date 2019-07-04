package com.jdroid.java.http

import com.jdroid.java.utils.LoggerUtils
import java.io.InputStream

abstract class HttpResponseWrapper {

    companion object {
        private val LOGGER = LoggerUtils.getLogger(HttpResponseWrapper::class.java)
    }

    abstract fun getStatusCode(): Int

    abstract fun getStatusReason(): String

    abstract fun getHeader(name: String): String?

    fun logStatusCode(): String {
        val sb = StringBuilder()
        sb.append("HTTP Status code: ")
        sb.append(getStatusCode())
        sb.append(" Reason: ")
        sb.append(getStatusReason())
        if (isSuccess()) {
            LOGGER.debug(sb.toString())
        } else {
            LOGGER.warn(sb.toString())
        }
        return sb.toString()
    }

    fun isSuccess(): Boolean {
        val code = getStatusCode()
        return code in 200..299
    }

    fun isClientError(): Boolean {
        val code = getStatusCode()
        return code in 400..499
    }

    fun isServerError(): Boolean {
        val code = getStatusCode()
        return code in 500..599
    }

    abstract fun getInputStream(): InputStream?
}
