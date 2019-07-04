package com.jdroid.java.http.okhttp.patch

import com.jdroid.java.http.HttpMethod
import com.jdroid.java.http.HttpServiceProcessor
import com.jdroid.java.http.Server
import com.jdroid.java.http.okhttp.OkBodyEnclosingHttpService

import okhttp3.Request
import okhttp3.RequestBody

class OkPatchHttpService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>) :
    OkBodyEnclosingHttpService(server, urlSegments, httpServiceProcessors) {

    override fun onConfigureRequestBuilder(builder: Request.Builder, requestBody: RequestBody?) {
        builder.patch(requestBody!!)
    }

    override fun getHttpMethod(): HttpMethod {
        return HttpMethod.PATCH
    }
}
