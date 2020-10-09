package top.minicraft.creepwar.listener

import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.server.ServerListPingEvent
import top.minicraft.creepwar.controller.GameController
import top.minicraft.creepwar.controller.PlayerController.gamePlayer
import top.minicraft.creepwar.datas.Settings

@TListener
object PlayerListener: Listener{
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        if(!Settings.settings.getBoolean("bungeecord.enable")){
            return
        }

    }

}