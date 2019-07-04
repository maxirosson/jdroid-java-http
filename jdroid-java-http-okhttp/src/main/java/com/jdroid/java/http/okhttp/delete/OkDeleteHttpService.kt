package com.jdroid.java.http.okhttp.delete

import com.jdroid.java.http.HttpMethod
import com.jdroid.java.http.HttpServiceProcessor
import com.jdroid.java.http.Server
import com.jdroid.java.http.okhttp.OkHttpService

import okhttp3.Request

class OkDeleteHttpService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>) :
    OkHttpService(server, urlSegments, httpServiceProcessors) {

    override fun onConfigureRequestBuilder(builder: Request.Builder) {
        builder.delete()
    }

    override fun getHttpMethod(): HttpMethod {
        return HttpMethod.DELETE
    }
}
