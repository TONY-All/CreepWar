package top.minicraft.randomevent

import io.izzel.taboolib.module.locale.TLocale
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitTask
import java.util.*
import kotlin.collections.ArrayList

interface GameRandomEvent {
    fun doEvent(players: List<Player>)
    companion object{
        val events = ArrayList<GameRandomEvent>()
        init {
            events.add(StandUp)
        }
        fun randomEvent(): GameRandomEvent {
            return events[Random().nextInt(events.size)]
        }
    }
}

object StandUp: GameRandomEvent {
    override fun doEvent(players: List<Player>) {
        players.forEach {
            it.sendMessage("A Message")
            TLocale.Display.sendTitle(it,"game.event.stand.title","",1,20,1)
            val block = it.location.add(0.0, 1.0, 0.0).block
            val type = block.type
            block.setType(Material.AIR,true)
            var time = 25
            var task: BukkitTask? = null
            task = Bukkit.getScheduler().runTaskTimer(RandEvent.plugin,Runnable{
                if (time <= 0) {
                    it.sendMessage("game.event.stand.creep")
                    it.noDamageTicks = 10
                    block.type = type
                    time = 0
                    task!!.cancel()
                    return@Runnable
                }
                time--
                TLocale.Display.sendActionBar(it, "game.event.stand.action $time")
            }, 0L, 20L)
        }
    }
}