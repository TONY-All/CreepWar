package top.minicraft.creepwar.game

import org.bukkit.Material
import org.bukkit.block.Block
import java.util.*
import kotlin.collections.ArrayList

object MapGenerator {
    fun generate(seed: Long,area: GameArea) {
        val random = Random(seed)
        val reLocates = ArrayList<Block>()
        area.getLocations().forEach {
            if(it.block.type != Material.DIRT){
                return@forEach
            }
            it.block.type = Material.AIR
            reLocates.add(it.block)
        }
        
    }
}