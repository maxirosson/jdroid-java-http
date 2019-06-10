package com.jdroid.java.http

interface Server {

    fun getServerName(): String

    fun getBaseUrl(): String

    fun supportsSsl(): Boolean

    fun isProduction(): Boolean

    fun getHttpServiceProcessors(): List<HttpServiceProcessor>?

    fun instance(name: String): Server?
}
