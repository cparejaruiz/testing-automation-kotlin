package org.merlyn.qatest.server

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

class NetworkServer(private val port: Int) {

    @Serializable
    private data class Message(val content: String)

    private var handleMessage: ((String) -> Unit)? = null
    private lateinit var engine: NettyApplicationEngine

    fun setMessageHandler(handleMessage: (String) -> Unit) {
        this.handleMessage = handleMessage
    }

    fun start() {
        engine = embeddedServer(Netty, port = port) {
            install(ContentNegotiation) {
                json()
            }
            routing {
                get("/") {
                    call.respondText("GET is unsupported", ContentType.Text.Plain)
                }

                post("/") {
                    val message = call.receive<Message>()
                    handleMessage?.invoke(message.content)
                    call.respondText("Processed: ${message.content}", ContentType.Text.Plain)
                }
            }
        }.start()
    }

    fun stop() {
        engine.stop()
    }
}