package com.jdroid.java.http

import com.jdroid.java.http.post.BodyEnclosingHttpService
import java.io.ByteArrayInputStream

interface MultipartHttpService : BodyEnclosingHttpService {

    fun addPart(name: String, inputStream: ByteArrayInputStream, mimeType: String, filename: String)

    fun addPart(name: String, value: Any, mimeType: String)

    fun addJsonPart(name: String, value: Any)
}
