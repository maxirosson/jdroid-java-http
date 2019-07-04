package com.jdroid.java.http.exception

import com.jdroid.java.exception.ErrorCodeException

/**
 * Exception thrown when there are unknown HTTP errors while communicating with the server.
 */
class HttpResponseException(message: String) : ErrorCodeException(HttpErrorCode.HTTP_RESPONSE_ERROR, message) {

    init {
        isTrackable = true
    }

    companion object {
        private const val serialVersionUID = -1165226174367435109L
    }
}
