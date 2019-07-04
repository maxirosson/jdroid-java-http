package com.jdroid.java.http.mock

abstract class JsonMockHttpService(vararg urlSegments: Any) : AbstractMockHttpService(urlSegments) {

    override fun getMocksBasePath(): String {
        return MOCKS_BASE_PATH
    }

    override fun getMocksExtension(): String {
        return MOCKS_EXTENSION
    }

    companion object {
        private const val MOCKS_BASE_PATH = "mocks/json/"
        private const val MOCKS_EXTENSION = ".json"
    }
}
