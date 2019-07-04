package com.jdroid.java.http.exception

import com.jdroid.java.exception.ErrorCode
import com.jdroid.java.exception.ErrorCodeException

enum class HttpErrorCode : ErrorCode {

    CONNECTION_ERROR,
    HTTP_RESPONSE_ERROR;

    override fun getStatusCode(): String? {
        return null
    }

    override fun getTitleResId(): Int? {
        return null
    }

    override fun getDescriptionResId(): Int? {
        return null
    }

    override fun newErrorCodeException(vararg errorCodeParameters: Any): ErrorCodeException {
        return ErrorCodeException(this, *errorCodeParameters)
    }

    override fun newErrorCodeException(): ErrorCodeException {
        return ErrorCodeException(this)
    }

    override fun newErrorCodeException(throwable: Throwable): ErrorCodeException {
        return ErrorCodeException(this, throwable)
    }

    override fun newErrorCodeException(message: String): ErrorCodeException {
        return ErrorCodeException(this, message)
    }
}