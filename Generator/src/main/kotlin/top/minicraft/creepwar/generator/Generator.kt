package top.minicraft.creepwar.generator

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import org.bukkit.Bukkit

object Generator: Plugin() {
    @TInject("settings.yml")
    lateinit var settings: TConfig

    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aSuccessful loaded plugin generator.")
    }
}