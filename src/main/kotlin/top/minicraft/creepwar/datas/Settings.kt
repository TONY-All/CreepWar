package top.minicraft.creepwar.datas

import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject

object Settings {
    @TInject("settings.yml",locale = "lang")
    lateinit var settings:TConfig
    private set

    @TInject
    lateinit var dataSource: IDataSource
}