package com.jdroid.java.http.parser.json

import com.jdroid.java.json.JSONArray
import com.jdroid.java.json.JSONObject

class JsonArrayParser(private val parser: JsonParser<JSONObject>) : JsonParser<JSONArray>() {

    override fun parse(json: JSONArray): Any {
        return parseList<Any>(json, parser)
    }
}