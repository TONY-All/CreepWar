package top.minicraft.creepwar.game

import org.bukkit.Location
import org.bukkit.World

class GameArea(loc1: Location, loc2: Location) {
    private val world: World
    //region Poses
    val xMax: Int = loc1.blockX.coerceAtLeast(loc2.blockX)
    val yMax: Int = loc1.blockY.coerceAtLeast(loc2.blockY)
    val zMax: Int = loc1.blockZ.coerceAtLeast(loc2.blockZ)
    val xMin: Int = loc1.blockX.coerceAtMost(loc2.blockX)
    val yMin: Int = loc1.blockY.coerceAtMost(loc2.blockY)
    val zMin: Int = loc1.blockZ.coerceAtMost(loc2.blockZ)
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