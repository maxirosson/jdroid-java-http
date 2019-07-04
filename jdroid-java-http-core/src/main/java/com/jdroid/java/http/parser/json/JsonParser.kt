package com.jdroid.java.http.parser.json

import com.jdroid.java.collections.Lists
import com.jdroid.java.http.parser.Parser
import com.jdroid.java.json.JSONArray
import com.jdroid.java.json.JSONException
import com.jdroid.java.json.JSONObject
import com.jdroid.java.utils.LoggerUtils
import com.jdroid.java.utils.StreamUtils
import com.jdroid.java.utils.StringUtils
import java.io.InputStream

/**
 * JSON input streams parser
 *
 * @param <T>
</T> */
abstract class JsonParser<T> : Parser {

    override fun parse(input: String): Any {

        LOGGER.trace("Parsing started.")
        try {
            LOGGER.trace("Response: $input")

            // Create a wrapped JsonObject or JsonArray
            val json: T
            if (input.startsWith(ARRAY_PREFIX)) {
                json = JSONArray(input) as T
            } else {
                json = JSONObject(input) as T
            }

            // Parse the JSONObject
            return parse(json)
        } catch (e: JSONException) {
            val message = e.message
            if (message != null && input != null && message.startsWith("A JSONObject text must begin with '{'")) {
                throw JSONException("Invalid json [" + input.substring(0, Math.min(input.length, 70)) + "]")
            } else {
                throw e
            }
        } finally {
            LOGGER.trace("Parsing finished.")
        }
    }

    override fun parse(inputStream: InputStream): Any? {
        val content = StreamUtils.toString(inputStream)
        return if (StringUtils.isNotBlank(content)) parse(content) else null
    }

    /**
     * @param json
     * @return The parsed object
     */
    abstract fun parse(json: T): Any

    /**
     * Parses a list of items.
     *
     * @param <ITEM> The item's type.
     *
     * @param jsonObject The [JSONObject] to parse.
     * @param jsonKey The key for the Json array.
     * @param parser The [JsonParser] to parse each list item.
     * @return The parsed list.
    </ITEM> */
    protected fun <ITEM> parseList(jsonObject: JSONObject, jsonKey: String, parser: JsonParser<JSONObject>): List<ITEM> {
        return parseList(jsonObject.getJSONArray(jsonKey), parser)
    }

    /**
     * Parses a list of items.
     *
     * @param <ITEM> The item's type.
     *
     * @param jsonArray The [JSONArray] to parse.
     * @param parser The [JsonParser] to parse each list item.
     * @return The parsed list.
    </ITEM> */
    protected fun <ITEM> parseList(jsonArray: JSONArray?, parser: JsonParser<JSONObject>): List<ITEM> {
        val list = Lists.newArrayList<ITEM>()
        if (jsonArray != null) {
            val length = jsonArray.length()
            for (i in 0 until length) {
                val parse = parser.parse(jsonArray.getJSONObject(i)) as ITEM
                if (parse != null) {
                    list.add(parse)
                }
            }
        }
        return list
    }

    companion object {

        private val LOGGER = LoggerUtils.getLogger(JsonParser::class.java)
        private const val ARRAY_PREFIX = "["
    }
}
