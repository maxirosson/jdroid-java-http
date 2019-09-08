package com.jdroid.java.http.okhttp

import com.jdroid.java.http.HttpService
import okhttp3.Response
import java.io.IOException
import java.io.InputStream
import java.util.zip.GZIPInputStream

class ReadResponseCommand : OkHttpCommand<Response, InputStream>() {

    @Throws(IOException::class)
    override fun doExecute(response: Response): InputStream? {
        var inputStream: InputStream? = null
        if (response.code != 204) {
            inputStream = response.body?.byteStream()
            val contentEncoding = response.header(HttpService.CONTENT_ENCODING_HEADER)
            if (inputStream != null && contentEncoding != null && contentEncoding.equals(HttpService.GZIP_ENCODING, ignoreCase = true)) {
                inputStream = GZIPInputStream(inputStream)
            }
        }
        return inputStream
    }
}
