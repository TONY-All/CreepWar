package top.minicraft.creepwar.listener

import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import top.minicraft.creepwar.datas.Settings

@TListener
object PlayerListener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        if(!Settings.settings.getBoolean("bungeecord.enable")){
            return
        }
        
    }
}