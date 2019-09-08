package com.jdroid.java.http.okhttp

import com.jdroid.java.http.HttpService
import com.jdroid.java.http.HttpServiceFactory
import com.jdroid.java.http.HttpServiceProcessor
import com.jdroid.java.http.MultipartHttpService
import com.jdroid.java.http.Server
import com.jdroid.java.http.okhttp.delete.OkDeleteHttpService
import com.jdroid.java.http.okhttp.get.OkGetHttpService
import com.jdroid.java.http.okhttp.patch.OkPatchHttpService
import com.jdroid.java.http.okhttp.post.OkPostHttpService
import com.jdroid.java.http.okhttp.put.OkPutHttpService
import com.jdroid.java.http.post.BodyEnclosingHttpService
import okhttp3.Interceptor

class OkHttpServiceFactory : HttpServiceFactory {

    protected var networkInterceptors: MutableList<Interceptor> = mutableListOf()

    override fun newGetService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): HttpService {
        val service = OkGetHttpService(server, urlSegments, httpServiceProcessors)
        service.setNetworkInterceptors(networkInterceptors)
        return service
    }

    override fun newPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService {
        val service = OkPostHttpService(server, urlSegments, httpServiceProcessors)
        service.setNetworkInterceptors(networkInterceptors)
        return service
    }

    override fun newMultipartPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): MultipartHttpService {
        throw UnsupportedOperationException()
    }

    override fun newMultipartPutService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): MultipartHttpService {
        throw UnsupportedOperationException()
    }

    override fun newFormPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService {
        throw UnsupportedOperationException()
    }

    override fun newPutService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService {
        val service = OkPutHttpService(server, urlSegments, httpServiceProcessors)
        service.setNetworkInterceptors(networkInterceptors)
        return service
    }

    override fun newPatchService(baseURL: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService {
        val service = OkPatchHttpService(baseURL, urlSegments, httpServiceProcessors)
        service.setNetworkInterceptors(networkInterceptors)
        return service
    }

    override fun newDeleteService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): HttpService {
        val service = OkDeleteHttpService(server, urlSegments, httpServiceProcessors)
        service.setNetworkInterceptors(networkInterceptors)
        return service
    }

    fun addNetworkInterceptor(networkInterceptor: Interceptor) {
        this.networkInterceptors.add(networkInterceptor)
    }
}
