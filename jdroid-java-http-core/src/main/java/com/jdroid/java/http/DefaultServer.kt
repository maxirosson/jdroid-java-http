package com.jdroid.java.http

class DefaultServer(private val name: String, private val baseUrl: String, private val supportsSsl: Boolean) : Server {

    constructor(baseUrl: String) : this(DefaultServer::class.java.simpleName, baseUrl, true) {}

    override fun getServerName(): String {
        return name
    }

    override fun getBaseUrl(): String {
        return baseUrl
    }

    override fun supportsSsl(): Boolean {
        return supportsSsl
    }

    override fun isProduction(): Boolean {
        return true
    }

    override fun getHttpServiceProcessors(): List<HttpServiceProcessor>? {
        return listOf(BasicHttpResponseValidator())
    }

    override fun instance(name: String): Server? {
        return null
    }
}
