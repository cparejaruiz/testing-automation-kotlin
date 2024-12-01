package org.merlyn.qatest.client

import javafx.scene.control.TextField
import javafx.scene.control.Button
import javafx.scene.control.Label
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.api.FxAssert
import org.testfx.matcher.control.LabeledMatchers
import org.testfx.matcher.control.TextInputControlMatchers
import org.testfx.matcher.base.NodeMatchers
import javafx.stage.Stage

class ClientAppTest : ApplicationTest() {

    // This method sets up the application stage for testing
    override fun start(stage: Stage) {
        val app = ClientApp()
        app.start(stage)
    }

    @Test
    fun testSendMessage() {
        // Interact with the client application
        clickOn("#input").write("Hello, Server!")
        clickOn("#send")

        // Verify that the message was sent
        FxAssert.verifyThat("#result", LabeledMatchers.hasText("200 OK -> Processed: Hello, Server!"))
    }

    @Test
    fun testEmptyMessage() {
        // Try to send an empty message
        clickOn("#send")

        // Verify that an appropriate error message is shown
        FxAssert.verifyThat("#result", LabeledMatchers.hasText("200 OK -> Processed: "))
    }

    @Test
    fun testSpecialCharactersMessage() {
        // Send a message with special characters
        clickOn("#input").write("!@#$%^&*()")
        clickOn("#send")

        // Verify that the message was sent
        FxAssert.verifyThat("#result", LabeledMatchers.hasText("200 OK -> Processed: !@#$%^&*()"))
    }

    @Test
    fun testLongMessage() {
        // Send a very long message
        val longMessage = "a".repeat(10)
        clickOn("#input").write(longMessage)
        clickOn("#send")

        // Verify that the message was sent
        FxAssert.verifyThat("#result", LabeledMatchers.hasText("200 OK -> Processed: aaaaaaaaaa"))
    }
}