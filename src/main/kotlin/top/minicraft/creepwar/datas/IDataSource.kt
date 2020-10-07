package top.minicraft.creepwar.datas

import org.bukkit.entity.Player
import top.minicraft.creepwar.game.GamePlayer

interface IDataSource {
    fun getPlayerData(player: Player): GamePlayer
}