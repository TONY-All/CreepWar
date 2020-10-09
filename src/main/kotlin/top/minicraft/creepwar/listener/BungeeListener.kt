package top.minicraft.creepwar.listener

import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import top.minicraft.creepwar.controller.GameController
import top.minicraft.creepwar.datas.Settings

@TListener
object BungeeListener: Listener{
    @EventHandler
    fun onMotd(e: ServerListPingEvent) {
        // do not modify motd if bungee isn't enable
        if(!Settings.settings.getBoolean("bungeecord.enable")){
            return
        }

        // game for bungee
        val defaultGame = GameController.defaultGame

        // deal unsetted up
        if(defaultGame == null){
            e.motd = Settings.settings.getStringColored("bungeecord.motd.unsetted")
            return
        }

        // setup title
        e.motd = Settings.settings.getStringColored(defaultGame.state.motdPath)
    }
}