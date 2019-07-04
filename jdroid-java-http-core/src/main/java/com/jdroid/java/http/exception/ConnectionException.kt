package com.jdroid.java.http.exception

import com.jdroid.java.exception.ErrorCodeException

/**
 * Exception related with connectivity errors.
 */
class ConnectionException : ErrorCodeException {

    var isReadTimeout = false

    constructor(throwable: Throwable) : super(HttpErrorCode.CONNECTION_ERROR, throwable) {}

    constructor(message: String) : super(HttpErrorCode.CONNECTION_ERROR, message) {}

    constructor(throwable: Throwable, readTimeout: Boolean) : this(throwable) {
        this.isReadTimeout = readTimeout
    }

    companion object {

        private const val serialVersionUID = 7201698090980820539L
    }
}
