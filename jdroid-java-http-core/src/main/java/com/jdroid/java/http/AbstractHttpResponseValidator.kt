package com.jdroid.java.http

import com.jdroid.java.exception.ErrorCode
import com.jdroid.java.http.exception.HttpResponseException
import com.jdroid.java.utils.LoggerUtils

abstract class AbstractHttpResponseValidator : BasicHttpResponseValidator() {

    companion object {
        private val LOGGER = LoggerUtils.getLogger(AbstractHttpResponseValidator::class.java)
        private const val STATUS_CODE_HEADER = "status-code"
        private const val SUCCESSFUL_STATUS_CODE = "200"
    }

    override fun onSuccess(httpResponse: HttpResponseWrapper, message: String) {
        val errorCode = getErrorCode(httpResponse)
        if (errorCode != null) {
            throw errorCode.newErrorCodeException()
        }
    }

    override fun onClientError(httpResponse: HttpResponseWrapper, message: String) {
        val errorCode = getErrorCode(httpResponse)
        if (errorCode != null) {
            throw errorCode.newErrorCodeException()
        } else {
            throw HttpResponseException(message)
        }
    }

    private fun getErrorCode(httpResponse: HttpResponseWrapper): ErrorCode? {
        var errorCode: ErrorCode? = null
        val statusCode = httpResponse.getHeader(STATUS_CODE_HEADER)
        if (statusCode != null) {
            LOGGER.debug("Server Status code: $statusCode")
            if (statusCode != SUCCESSFUL_STATUS_CODE) {
                errorCode = findByStatusCode(statusCode)
                if (errorCode == null) {
                    errorCode = findByCommonStatusCode(statusCode)
                    if (errorCode == null) {
                        LOGGER.warn("Unknown Server Status code: $statusCode")
                        throw HttpResponseException("Unknown Server Status code: $statusCode")
                    }
                }
            }
        }
        return errorCode
    }

    protected abstract fun findByCommonStatusCode(statusCode: String): ErrorCode?

    protected abstract fun findByStatusCode(statusCode: String): ErrorCode?
}