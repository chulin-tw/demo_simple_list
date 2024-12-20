package com.example.moments.data.api

import com.example.moments.data.model.ListItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL

private const val DOMAIN_URL = "192.168.31.246"
private const val TIME_OUT = 10000

class ListApiClient {
    suspend fun getList(): List<ListItem>? {
        var connection: HttpURLConnection? = null
        try {
            connection = URL("http://$DOMAIN_URL:3022").openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = TIME_OUT
            connection.readTimeout = TIME_OUT
            connection.connect()
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                connection.inputStream.bufferedReader().use { reader ->
                    val json = reader.readText()
                    return parseJsonToList(json)
                }
            } else {
                throw Exception("Error loading data in ListApiClient: $responseCode")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            connection?.disconnect()
        }
    }

    private fun parseJsonToList(json: String): List<ListItem> {
        val listType = object : TypeToken<List<ListItem>>() {}.type
        return Gson().fromJson(json, listType)
    }
}