package top.minicraft.randomevent

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.command.base.BaseCommand
import io.izzel.taboolib.module.command.base.BaseMainCommand
import io.izzel.taboolib.module.command.base.BaseSubCommand
import io.izzel.taboolib.module.command.base.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object RandEvent: Plugin() {
    override fun onEnable() {
        ChatColor.values().forEach {
            Bukkit.getConsoleSender().sendMessage("${it}9z9z?")
        }
    }
}

@BaseCommand(name = "randomEvent",permission = "revent.use",description = "Command to call REvent",usage = "/revent",aliases = ["revent"])
class Commands: BaseMainCommand() {

    @SubCommand(description = "Do a event on all player")
    val `do` = object: BaseSubCommand() {
        override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>) {
            GameRandomEvent.randomEvent().doEvent(ArrayList(Bukkit.getOnlinePlayers()))
        }
    }
}