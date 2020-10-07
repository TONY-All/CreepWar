package top.minicraft.creepwar.datas.datasource

import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import org.bukkit.entity.Player
import top.minicraft.creepwar.datas.IDataSource
import top.minicraft.creepwar.game.GamePlayer
import top.minicraft.creepwar.statistic.MineStatistic

object Yaml: IDataSource {
    @TInject("data.yml")
    private lateinit var data: TConfig

    override fun getPlayerData(player: Player): GamePlayer {
        val section = data.getConfigurationSection("players.${player.uniqueId}") ?: return GamePlayer(player,0,0,0, MineStatistic())
        return GamePlayer(player, section.getInt("kills"),section.getInt("games"),section.getInt("wins"),section["blockdata"] as MineStatistic)
    }
}