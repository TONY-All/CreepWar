package top.minicraft.creepwar.generator

import io.izzel.taboolib.module.command.base.*
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.lang.NumberFormatException
import java.util.*
import kotlin.collections.ArrayList

@BaseCommand(name = "generator",description = "范围生成fw")
class Command: BaseMainCommand() {

    @SubCommand(permission = "generator.gen",arguments = ["x1","y1","z1","x2","y2","z2"],type = CommandType.PLAYER)
    val gen = object: BaseSubCommand() {
        override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>) {
            try {
                val x1 = args[0].toInt()
                val y1 = args[1].toInt()
                val z1 = args[2].toInt()
                val x2 = args[3].toInt()
                val y2 = args[4].toInt()
                val z2 = args[5].toInt()
                sender as Player
                val area = GameArea(
                        Location(sender.world, x1.toDouble(), y1.toDouble(), z1.toDouble()),
                        Location(sender.world, x2.toDouble(), y2.toDouble(), z2.toDouble())
                )

                val blocks = ArrayList<Block>()
                area.getLocations().forEach {
                    if(it.block.type != Material.DIRT){
                        return@forEach
                    }
                    it.block.type = Material.AIR
                    blocks.add(it.block)
                }
                val genables = readConfig()
                val random = Random()
                val start = System.currentTimeMillis()
                blocks.forEach {
                    it.type = genables[random.nextInt(genables.size)]
                }
                sender.sendMessage("§a Successful replaced all blocks.\n§b Time used: ${System.currentTimeMillis() - start} ms")
            }catch (e: NumberFormatException) {
                sender.sendMessage("§c 参数不合法")
                return
            }
        }

        fun readConfig():List<Material>{
            val result = ArrayList<Material>()
            Generator.settings.getConfigurationSection("blocks")!!.getKeys(false).forEach{
                val mat = Material.valueOf(it.toUpperCase())
                for (time in 1..Generator.settings.getInt("blocks.${it}")) {
                    result.add(mat)
                }
            }
            return result
        }
    }
}

class GameArea(loc1: Location, loc2: Location) {
    private val world: World
    //region Poses
    private val xMax: Int = loc1.blockX.coerceAtLeast(loc2.blockX)
    private val yMax: Int = loc1.blockY.coerceAtLeast(loc2.blockY)
    private val zMax: Int = loc1.blockZ.coerceAtLeast(loc2.blockZ)
    private val xMin: Int = loc1.blockX.coerceAtMost(loc2.blockX)
    private val yMin: Int = loc1.blockY.coerceAtMost(loc2.blockY)
    private val zMin: Int = loc1.blockZ.coerceAtMost(loc2.blockZ)
    //endregion

    init {
        if(loc1.world == loc2.world){
            world = loc1.world!!
        }else{
            throw Exception("Not in the same world")
        }
    }

    fun isIn(location: Location): Boolean{
        return  location.x < xMax && location.x > xMin &&
                location.y < yMin && location.y > yMin &&
                location.z < zMax && location.z > zMin
    }

    fun getLocations(): List<Location>{
        val result = ArrayList<Location>()
        for (x in xMin..xMax){
            for (y in yMin..yMax){
                for (z in zMin..zMax){
                    result.add(Location(world, x.toDouble(), y.toDouble(), z.toDouble()))
                }
            }
        }
        return result
    }
}