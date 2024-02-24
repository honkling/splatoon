plugins {
    kotlin("jvm") version "1.9.0"
}

group = "me.honkling"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io/")
}

kotlin {
    jvmToolchain(17)
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
}