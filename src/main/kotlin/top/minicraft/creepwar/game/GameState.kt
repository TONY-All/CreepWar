package top.minicraft.creepwar.game

enum class GameState(val motdPath: String){
    WAITING("bungeecord.motd.waiting"),
    STARTING("bungeecord.motd.waiting"),
    FULL("bungeecord.motd.full"),
    GENERATING("bungeecord.motd.started"),
    STARTED("bungeecord.motd.started"),
    ENDED("bungeecord.motd.resetting")
}