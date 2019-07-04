package com.jdroid.java.http

interface HttpServiceProcessor {

    /**
     * The logic to be executed when this processor is added to the HttpService. It could be executed on the HttpService creation or
     * after the processor is added to the HttpService.
     *
     * @param httpService The HttpService where the processor is executed
     */
    fun onInit(httpService: HttpService)

    fun beforeExecute(httpService: HttpService)

    fun afterExecute(httpService: HttpService, httpResponse: HttpResponseWrapper)
}