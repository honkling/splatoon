plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

group = "me.honkling.splatoon"
version = "0.1.0"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io/")
}

dependencies {
    implementation("com.github.Minestom:Minestom:b58db7d5b0")
    implementation("com.github.airbrushgg:plugins:3f2f6c2fd9")
}

application {
    mainClass.set("me.honkling.splatoon.server.MainKt")
}