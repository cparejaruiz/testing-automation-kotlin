package org.merlyn.qatest.client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

class NetworkClient(private val endpoint: String) {

    @Serializable
    private data class Message(val content: String)

    private val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun sendMessage(message: String): String {
        val response: HttpResponse = client.post(endpoint) {
            contentType(ContentType.Application.Json)
            setBody(Message(message))
        }
        return "${response.status.value} ${response.status.description} -> ${response.body<String>()}"
    }
}