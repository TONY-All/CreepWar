package top.minicraft.creepwar.game

import io.izzel.taboolib.module.locale.TLocale
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.scheduler.BukkitTask
import top.minicraft.creepwar.CreepWar
import java.util.*
import kotlin.collections.ArrayList

interface GameRandomEvent {
    fun doEvent(game: Game)
    companion object{
        val events = ArrayList<GameRandomEvent>()
        init {
            events.add(StandUp)
        }
        fun randomEvent(): GameRandomEvent{
            return events[Random().nextInt(events.size)]
        }
    }
}

object StandUp: GameRandomEvent {
    override fun doEvent(game: Game) {
        game.players.forEach {
            TLocale.Display.sendTitle(it,TLocale.asString("game.event.stand.title"),"",1,20,1)
            val block = it.location.add(0.0, 1.0, 0.0).block
            val type = block.type
            block.setType(Material.AIR,true)
            var time = 25
            var task: BukkitTask? = null
            task = Bukkit.getScheduler().runTaskTimer(CreepWar.plugin,Runnable{
                if (time <= 0) {
                    TLocale.sendTo(it,"game.event.stand.creep")
                    it.noDamageTicks = 10
                    block.type = type
                    time = 0
                    task!!.cancel()
                    return@Runnable
                }
                time--
                TLocale.Display.sendActionBar(it, TLocale.asString("game.event.stand.action", time))
            }, 0L, 20L)
        }
    }
}