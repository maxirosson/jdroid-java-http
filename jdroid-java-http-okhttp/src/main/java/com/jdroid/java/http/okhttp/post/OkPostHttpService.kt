package com.jdroid.java.http.okhttp.post

import com.jdroid.java.http.HttpMethod
import com.jdroid.java.http.HttpServiceProcessor
import com.jdroid.java.http.MultipartHttpService
import com.jdroid.java.http.Server
import com.jdroid.java.http.okhttp.OkBodyEnclosingHttpService
import okhttp3.Request
import okhttp3.RequestBody
import java.io.ByteArrayInputStream

class OkPostHttpService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>) :
    OkBodyEnclosingHttpService(server, urlSegments, httpServiceProcessors), MultipartHttpService {

    override fun onConfigureRequestBuilder(builder: Request.Builder, requestBody: RequestBody?) {
        builder.post(requestBody!!)
    }

    override fun getHttpMethod(): HttpMethod {
        return HttpMethod.POST
    }

    override fun addPart(name: String, `in`: ByteArrayInputStream, mimeType: String, filename: String) {
        throw UnsupportedOperationException()
    }

    override fun addPart(name: String, value: Any, mimeType: String) {
        throw UnsupportedOperationException()
    }

    override fun addJsonPart(name: String, value: Any) {
        throw UnsupportedOperationException()
    }
}
