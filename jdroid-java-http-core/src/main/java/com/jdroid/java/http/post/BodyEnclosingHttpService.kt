package com.jdroid.java.http.post

import com.jdroid.java.http.HttpService

interface BodyEnclosingHttpService : HttpService {

    fun setBody(body: String)
}
