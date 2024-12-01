package org.merlyn.qatest.server

import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotlinx.coroutines.*

class ClientApp : Application() {

    override fun start(primaryStage: Stage) {
        val label = Label()
        label.text = "Request:"

        val result = Label()

        // Testing
        result.id = "result"

        val vbox = VBox(10.0, label, result)
        val scene = Scene(vbox, 300.0, 200.0)

        startServer(result)

        primaryStage.title = "Server App"
        primaryStage.scene = scene
        primaryStage.show()
    }

    override fun stop() {
        stopServer()
        super.stop()
    }

    private fun startServer(result: Label) {
        networkServer.setMessageHandler  {
            println(it)
            Platform.runLater { result.text = it }
        }
    }

    private fun stopServer() {
        networkServer.stop()
    }
}

lateinit var networkServer: NetworkServer

fun main() = runBlocking {
    networkServer = NetworkServer(4000)

    launch(Dispatchers.IO) {
        networkServer.start()
    }

    Application.launch(ClientApp::class.java)
}
