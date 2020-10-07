package top.minicraft.creepwar.statistic

import io.izzel.taboolib.module.locale.TLocale
import org.bukkit.Material
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.configuration.serialization.SerializableAs

@SerializableAs("MineData")
class MineStatistic(): ConfigurationSerializable {
    lateinit var mineMap: MutableMap<Material,Int>

    constructor(map: Map<String,Any>): this(){
        map.forEach {(name,num) ->
            val material = Material.valueOf(name)
            val number = num as Int
            mineMap[material] = number
            TLocale.sendToConsole("console.loadplayer.error")
        }
    }

    fun mine(material: Material){
        if(!material.isBlock){
            TLocale.sendToConsole("console.error.mine",material.name)
            return
        }
        var value = mineMap[material]
        if(value == null) value = 1 else value++
        mineMap[material] = value
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = HashMap<String,Any>()
        mineMap.forEach { (material, number) -> map[material.name] = number}
        return map
    }
}