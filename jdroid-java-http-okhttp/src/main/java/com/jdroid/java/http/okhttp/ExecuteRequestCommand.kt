package com.jdroid.java.http.okhttp

import java.io.IOException

class ExecuteRequestCommand : OkHttpCommand<OkHttpService, OkHttpResponseWrapper>() {

    @Throws(IOException::class)
    override fun doExecute(okHttpService: OkHttpService): OkHttpResponseWrapper? {
        val response = okHttpService.client.newCall(okHttpService.request).execute()
        return OkHttpResponseWrapper(response)
    }
}
