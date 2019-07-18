package com.jdroid.java.http

import com.jdroid.java.http.post.BodyEnclosingHttpService

interface HttpServiceFactory {

    fun newGetService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): HttpService

    fun newPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService

    fun newMultipartPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): MultipartHttpService

    fun newMultipartPutService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): MultipartHttpService

    fun newFormPostService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService

    fun newPutService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService

    fun newPatchService(baseURL: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): BodyEnclosingHttpService

    fun newDeleteService(server: Server, urlSegments: List<Any>, httpServiceProcessors: List<HttpServiceProcessor>): HttpService
}
