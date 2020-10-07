package top.minicraft.creepwar

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import io.izzel.taboolib.module.locale.TLocale
import org.bukkit.Bukkit
import top.minicraft.creepwar.datas.Settings
import top.minicraft.creepwar.datas.datasource.Sql
import top.minicraft.creepwar.datas.datasource.Yaml

object CreepWar: Plugin() {

    override fun onEnable() {
        """P
            §b ,---.                   |     |
            §b |    ,--.,---.,---.,---.| ,-. |,---.,--.
            §b |    |   |---'|---'|---'| | | |,---||
            §b '---'`   `---'`---''    `-` `-``---^`
        """.trimIndent().lines().forEach {Bukkit.getConsoleSender().sendMessage(it)}
        TLocale.sendToConsole("console.load.plugin")
        TLocale.sendToConsole("console.load.datasource")
        setupDataSource()
    }

    private fun setupDataSource() {
        when(Settings.settings.getString("dataSource")){
            "sql" -> {
                Settings.dataSource = Sql
            }
            "yaml" -> {
                Settings.dataSource = Yaml
            }
        }
    }
}