package com.jdroid.java.http.parser.json

import com.jdroid.java.json.JSONObject

class ValueJsonParser(private val key: String) : JsonParser<JSONObject>() {

    override fun parse(json: JSONObject): Any? {
        return json.opt(key)
    }
}
