package com.jdroid.java.http.cache

interface Cache {

    fun getPriority(): Int

    fun getMinimumSize(): Float

    fun getMaximumSize(): Float

    fun getName(): String

    fun getDefaultContent(): Map<String, String>
}
