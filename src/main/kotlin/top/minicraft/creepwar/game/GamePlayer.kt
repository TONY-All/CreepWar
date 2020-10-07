package top.minicraft.creepwar.game

import org.bukkit.Material
import org.bukkit.entity.Player
import top.minicraft.creepwar.statistic.MineStatistic

class GamePlayer(val Player: Player,var kill:Int,var games:Int,var wins:Int,val mineData: MineStatistic) {

    var currentKill = 0

    fun mine(material: Material){
        mineData.mine(material)
    }
}