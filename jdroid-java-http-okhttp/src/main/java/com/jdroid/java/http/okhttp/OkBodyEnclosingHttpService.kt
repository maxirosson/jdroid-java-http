package com.jdroid.java.http.okhttp

import com.jdroid.java.http.AbstractHttpService
import com.jdroid.java.http.HttpServiceProcessor
import com.jdroid.java.http.MimeType
import com.jdroid.java.http.Server
import com.jdroid.java.http.post.BodyEnclosingHttpService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

abstract class OkBodyEnclosingHttpService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>) : OkHttpService(server, urlSegments, httpServiceProcessors), BodyEnclosingHttpService {

    private var body: String? = null

    override fun onConfigureRequestBuilder(builder: Request.Builder) {

        var requestBody: RequestBody? = null
        if (body != null) {
            AbstractHttpService.LOGGER.debug("Body: $body")
            requestBody = body!!.toRequestBody(MimeType.JSON.toMediaType())
        }
        onConfigureRequestBuilder(builder, requestBody)
    }

    protected abstract fun onConfigureRequestBuilder(builder: Request.Builder, requestBody: RequestBody?)

    override fun setBody(body: String) {
        this.body = body
    }
}
