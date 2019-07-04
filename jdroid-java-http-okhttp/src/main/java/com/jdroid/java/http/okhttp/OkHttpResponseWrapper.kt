package com.jdroid.java.http.okhttp

import com.jdroid.java.http.HttpResponseWrapper
import okhttp3.Response
import java.io.InputStream

class OkHttpResponseWrapper(val response: Response) : HttpResponseWrapper() {
    private var inputStream: InputStream? = null

    override fun getStatusCode(): Int {
        return response.code
    }

    override fun getStatusReason(): String {
        return response.message
    }

    override fun getHeader(name: String): String? {
        return response.header(name)
    }

    override fun getInputStream(): InputStream? {
        if (inputStream == null) {
            inputStream = ReadResponseCommand().execute(response)
        }
        return inputStream
    }
}
