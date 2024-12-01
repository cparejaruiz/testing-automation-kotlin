package org.merlyn.qatest.server

import javafx.scene.control.Label
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.api.FxAssert
import org.testfx.matcher.control.LabeledMatchers
import javafx.stage.Stage

class ServerAppTest : ApplicationTest() {

    override fun start(stage: Stage) {
        val app = ServerApp()
        app.start(stage)
    }

    @Test
    fun testReceiveMessage() {
        FxAssert.verifyThat("#result", LabeledMatchers.hasText("Server is running"))
    }
}