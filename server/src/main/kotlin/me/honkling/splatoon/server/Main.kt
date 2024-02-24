package me.honkling.splatoon.server

import gg.airbrush.plugins.PluginManager
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent
import net.minestom.server.instance.block.Block

val server = MinecraftServer.init()
val instances = MinecraftServer.getInstanceManager()
val events = MinecraftServer.getGlobalEventHandler()
val plugins = PluginManager()

val container = instances.createInstanceContainer()

fun main() {
    registerEvents()
    container.setGenerator { it.modifier().fillHeight(0, 40, Block.GRASS_BLOCK) }

    plugins.registerPlugins()
    plugins.setupPlugins()
    Runtime.getRuntime().addShutdownHook(Thread(plugins::teardownPlugins))

    server.start("0.0.0.0", 25565)
}

private fun registerEvents() {
    events.addListener(AsyncPlayerConfigurationEvent::class.java) { event ->
        val player = event.player
        event.spawningInstance = container
        player.respawnPoint = Pos(0.0, 42.0, 0.0)
    }
}