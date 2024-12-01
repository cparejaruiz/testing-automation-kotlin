package org.merlyn.qatest.client

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ClientApp : Application() {

    private val networkClient = NetworkClient("http://localhost:4000")

    override fun start(primaryStage: Stage) {
        val textField = TextField()
        val button = Button("Send")
        val result = Label()

        // Testing
        textField.id = "input"
        button.id = "send"
        result.id = "result"

        button.setOnAction {
            val input = textField.text
            val status = runBlocking {
                withContext(Dispatchers.IO) {
                    networkClient.sendMessage(input)
                }
            }
            result.text = status
        }

        val vbox = VBox(10.0, textField, button, result)
        val scene = Scene(vbox, 300.0, 200.0)

        primaryStage.title = "Client App"
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main() {
    Application.launch(ClientApp::class.java)
}
