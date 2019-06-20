package com.jdroid.java.http.mock

abstract class XmlMockHttpService(vararg urlSegments: Any) : AbstractMockHttpService(urlSegments) {

    companion object {
        private const val MOCKS_BASE_PATH = "mocks/xml/"
        private const val MOCKS_EXTENSION = ".xml"
    }

    override fun getMocksBasePath(): String {
        return MOCKS_BASE_PATH
    }

    override fun getMocksExtension(): String {
        return MOCKS_EXTENSION
    }
}
