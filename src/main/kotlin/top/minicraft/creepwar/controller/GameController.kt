package top.minicraft.creepwar.controller

import top.minicraft.creepwar.game.Game

object GameController {
    val games = ArrayList<Game>()
    val defaultGame: Game? = null

    init {
        loadGames()
    }

    private fun loadGames(){

    }

//    fun getGame(): Game{
//
//    }
//
//    fun getGame(name: String): Game{
//
//    }
}