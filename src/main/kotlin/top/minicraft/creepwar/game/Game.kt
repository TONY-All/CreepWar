package top.minicraft.creepwar.game

import org.bukkit.entity.Player
import top.minicraft.creepwar.game.GameState.WAITING as WAITING
import top.minicraft.creepwar.game.GameState.STARTING as STARTING
import top.minicraft.creepwar.game.GameState.GENERATING as GENERATING
import top.minicraft.creepwar.game.GameState.STARTED as STARTED

class Game (val name: String,
            val overWorld: GameArea,
            val nether: GameArea,
            ){
    val players = ArrayList<Player>()
    val spectators = ArrayList<Player>()
    
    var state= WAITING
}