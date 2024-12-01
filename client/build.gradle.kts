plugins {
    id("java")
    kotlin("jvm")
    id("org.openjfx.javafxplugin")
    kotlin("plugin.serialization") version "2.0.21"
    application
}

group = "org.merlyn.helloworld"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.openjfx:javafx-controls:21.0.1")

    implementation("io.ktor:ktor-client-core:2.3.12")
    implementation("io.ktor:ktor-client-cio:2.3.12")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.testfx:testfx-junit5:4.0.16-alpha")
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    modules("javafx.controls")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("org.merlyn.qatest.client.ClientAppKt")
}