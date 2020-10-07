package top.minicraft.creepwar.controller

import org.bukkit.entity.Player
import top.minicraft.creepwar.datas.Settings
import top.minicraft.creepwar.game.GamePlayer
import java.util.*
import kotlin.collections.HashMap

object PlayerController {
    private val playerMap = HashMap<UUID,GamePlayer>()

    val Player.gamePlayer: GamePlayer
        get() {
            if(!playerMap.containsKey(this.uniqueId)){
                playerMap[this.uniqueId] = Settings.dataSource.getPlayerData(this)
            }
            return playerMap[this.uniqueId]!!
        }
}